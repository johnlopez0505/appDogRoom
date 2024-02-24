package com.example.appdogroom.domain.models

import com.example.appdogroom.data.dataBaseDog.entities.DogEntity


interface DogRepositoryInterface {
    fun getDogs() : List<DogModel>
    suspend fun getDogsBaseData() : List<DogModel>
    suspend fun getDogsBaseDataByBreed(breed: String):List<DogModel>
    suspend fun insertListDogBaseData(listDogs : List<DogEntity>)
    suspend fun insertDogBaseData() : List<DogModel>
    suspend fun deleteDogBaseData()
}