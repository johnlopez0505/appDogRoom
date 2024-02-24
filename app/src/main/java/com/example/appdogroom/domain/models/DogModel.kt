package com.example.appdogroom.domain.models

data class DogModel( val breed: String, val image: String){
    override fun toString(): String {
        return "DogModel(breed='$breed', image='$image')"
    }
}

