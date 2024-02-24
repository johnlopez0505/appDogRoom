package com.example.appdogroom.data.men.service

interface DogServiceInterface {
    fun getDogs(): List<Pair<String,String>>
    fun getBreedDogs (breed: String) : List<Pair<String,String>>
}