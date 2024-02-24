package com.example.appdogroom.domain.useCase

import com.example.appdogroom.domain.models.DogModel
import com.example.appdogroom.domain.models.DogRepository
import javax.inject.Inject

class GetDogsBreedUseCase @Inject constructor (
    private val dogRepositoryDao : DogRepository
){
    private var breed: String = ""
    fun setBreed (breed: String){
        this.breed = breed
    }
    suspend operator fun invoke() : List<DogModel>{
        return dogRepositoryDao.getDogsBaseDataByBreed(breed)
    }
}