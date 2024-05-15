package com.example.weather.data.repository

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.weather.data.storage.cities.City
import com.example.weather.data.storage.cities.CityDatabase
import com.example.weather.domain.repository.CityStorageRepository
import dagger.internal.Provider
import javax.inject.Inject

class CityStorageRepositoryImpl @Inject constructor(
    context: Context
) : CityStorageRepository {

    private val db = Room.databaseBuilder(
        context,
        CityDatabase::class.java, "city"
    ).allowMainThreadQueries().build()

    private val dao = db.dao

    override suspend fun upsertCity(name: String) {
        dao.upsert(City(name = name))
    }

    override suspend fun getListCity(): List<City> {
        return dao.getCityOrderedByName()
    }

    override suspend fun deleteCityByName(name: String) {
        dao.deleteByName(name)
    }
}