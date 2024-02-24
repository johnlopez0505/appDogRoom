package com.example.appdogroom.domain.mapper

import com.example.appdogroom.data.dataBaseDog.entities.DogEntity
import com.example.appdogroom.data.men.modelDog.Dog
import com.example.appdogroom.domain.models.DogModel


fun Dog.toDomain(): DogModel {
    return DogModel(breed = this.name, image = this.image)
}

fun DogEntity.toDomain(): DogModel {
    return DogModel(breed = this.breed, image = this.image)
}


fun DogModel .toDomain (): DogEntity {
    return DogEntity( breed = breed, image = image)
}
