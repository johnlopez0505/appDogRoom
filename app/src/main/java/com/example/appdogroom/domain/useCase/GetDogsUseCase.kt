package com.example.appdogroom.domain.useCase


import com.example.appdogroom.domain.models.DogModel
import com.example.appdogroom.domain.models.DogRepository
import com.example.appdogroom.domain.models.Repository
import javax.inject.Inject

class GetDogsUseCase @Inject constructor (
    private val dogRepositoryDao : DogRepository
) {

    suspend operator fun invoke(): List<DogModel> {
        Repository .dogs = dogRepositoryDao.getDogsBaseData()
        return Repository .dogs
    }
}