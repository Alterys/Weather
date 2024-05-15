package com.example.weather.data.storage.cities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class City(
    @ColumnInfo("name")
    @PrimaryKey
    val name: String,
)
