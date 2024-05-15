package com.example.weather.domain.repository

import com.example.weather.data.storage.cities.City
interface CityStorageRepository {
    suspend fun upsertCity(name: String)
    suspend fun getListCity(): List<City>
    suspend fun deleteCityByName(name: String)
}