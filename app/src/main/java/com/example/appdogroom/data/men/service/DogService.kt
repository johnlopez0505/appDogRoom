package com.example.appdogroom.data.men.service

import com.example.appdogroom.data.men.modelDogs.Dogs
import javax.inject.Inject
class DogService @Inject constructor(): DogServiceInterface {

    override fun getDogs(): List<Pair<String, String>> {
        return Dogs.dogs
    }

    override fun getBreedDogs(breed: String): List<Pair<String, String>> {
        val newDogs = Dogs.dogs.filter {
            it.first == breed
        }
        return newDogs
    }
}