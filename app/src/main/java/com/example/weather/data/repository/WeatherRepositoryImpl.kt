package com.example.weather.data.repository

import com.example.weather.common.Constants.API_KEY
import com.example.weather.common.Constants.DAYS
import com.example.weather.data.remote.response.Weather
import com.example.weather.data.remote.response.search.Search
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

    override suspend fun searchCity(city: String): List<Search> {
        return api.searchCity(
            API_KEY,
            city
        )
    }
}