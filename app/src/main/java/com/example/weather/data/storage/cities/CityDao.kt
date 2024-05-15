package com.example.weather.data.storage.cities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Query("DELETE FROM city WHERE name LIKE :name")
    suspend fun deleteByName(name: String)

    @Query("SELECT * FROM city ORDER BY name ASC")
    suspend fun getCityOrderedByName(): List<City>

    @Upsert
    suspend fun upsert(city: City)
}

