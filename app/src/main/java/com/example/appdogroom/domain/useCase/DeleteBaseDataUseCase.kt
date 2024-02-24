package com.example.appdogroom.domain.useCase


import com.example.appdogroom.domain.models.DogRepository

import javax.inject.Inject

class DeleteBaseDataUseCase @Inject constructor(
    private val dogRepositoryDao : DogRepository
) {

    suspend operator fun invoke() {
        dogRepositoryDao.deleteDogBaseData()
    }

}