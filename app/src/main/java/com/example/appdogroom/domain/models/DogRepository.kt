package com.example.appdogroom.domain.models


import com.example.appdogroom.data.dataBaseDog.dao.DogDao
import com.example.appdogroom.data.dataBaseDog.entities.DogEntity
import com.example.appdogroom.data.men.service.DogService
import com.example.appdogroom.domain.mapper.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepository @Inject constructor(
    private val service : DogService,
    private val dao: DogDao
) : DogRepositoryInterface{

    override fun getDogs(): List<DogModel> {
        val mutableDogs : MutableList<DogModel> = mutableListOf()
        val dataSource = service.getDogs()
        dataSource.forEach{ dog->
            mutableDogs.add(DogModel(dog.first, dog.second))
        }
        return mutableDogs
    }

    override suspend fun getDogsBaseData(): List<DogModel> =
        withContext(Dispatchers.IO){
            val listDogModel : List<DogModel>
            val listEntity : List<DogEntity> = dao.getAll()
            Repository.dogs = listEntity.map { it.toDomain() }
            if (Repository .dogs.isEmpty()){
                listDogModel = getDogs()
                val dataDogEntity : List<DogEntity> = listDogModel.map { it.toDomain() }
                insertListDogBaseData( dataDogEntity )
                Repository.dogs = listDogModel
            }
        return@withContext Repository.dogs
    }

    override suspend fun getDogsBaseDataByBreed(breed: String): List<DogModel> =
        withContext(Dispatchers.IO) {
            val listDogsBreed : List<DogEntity> = dao.getDogsByBreed(breed)
            Repository.dogs = listDogsBreed.map { it.toDomain() }
            return@withContext Repository.dogs
    }

    override suspend fun insertListDogBaseData(listDogs : List<DogEntity>): Unit =
        withContext(Dispatchers.IO) {
            dao.insertAllDog(listDogs)
    }

    override suspend fun insertDogBaseData(): List<DogModel> =
        withContext(Dispatchers.IO){
        TODO("Not yet implemented")
    }

    override suspend fun deleteDogBaseData(): Unit =
        withContext(Dispatchers.IO){
        dao.deleteAll()
    }
}