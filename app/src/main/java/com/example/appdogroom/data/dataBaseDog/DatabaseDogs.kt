package com.example.appdogroom.data.dataBaseDog

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appdogroom.data.dataBaseDog.dao.DogDao
import com.example.appdogroom.data.dataBaseDog.entities.DogEntity

@Database(entities = [DogEntity:: class], version = 1, exportSchema = false)
abstract class DatabaseDogs : RoomDatabase() {
    abstract fun dogDao(): DogDao

}