package com.example.weather.data.repository

import android.util.Log
import com.example.weather.data.remote.response.Weather
import com.example.weather.domain.repository.WeatherRepository
import retrofit2.Call

object WeatherRepositoryImpl: WeatherRepository {

    private val api = ApiModule.api

    override suspend fun getWeather(key: String, city: String): Weather {
        return api.getWeather(
            key,
            city
        )
    }
}