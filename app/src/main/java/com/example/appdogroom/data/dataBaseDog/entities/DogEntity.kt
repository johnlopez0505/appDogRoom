package com.example.appdogroom.data.dataBaseDog.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DogEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int =0,
    @ColumnInfo (name = "breed") val breed: String,
    @ColumnInfo (name="image") val image: String
)


