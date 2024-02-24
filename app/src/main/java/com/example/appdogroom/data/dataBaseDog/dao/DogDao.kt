package com.example.appdogroom.data.dataBaseDog.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.appdogroom.data.dataBaseDog.entities.DogEntity
@Dao
interface DogDao {

    @Query ("SELECT * FROM dogentity")
    suspend fun getAll(): List<DogEntity>

    @Query ("SELECT * FROM dogentity WHERE breed = :breed")
    fun getDogsByBreed(breed: String): List<DogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDog(vararg dogs : DogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDog(dogs: List<DogEntity>)

    @Query ("DELETE FROM dogentity")
    fun deleteAll()
}