package com.example.appdogroom.data.men.modelDog

data class Dog(
    val name: String,
    val image: String
)
{
    override fun toString(): String {
        return "Dog(name='$name', image='$image')"
    }
}