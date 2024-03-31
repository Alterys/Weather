package com.example.weather.data.repository

import com.example.weather.common.Constants.DAYS
import com.example.weather.common.secret.Secret.API_KEY

import com.example.weather.data.remote.response.Weather
import com.example.weather.domain.repository.WeatherRepository

object WeatherRepositoryImpl: WeatherRepository {

    private val api = ApiModule.api

    override suspend fun getWeather(city: String): Weather {
        return api.getWeather(
            API_KEY,
            city,
            DAYS
        )
    }
}