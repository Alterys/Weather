package com.example.weather.domain.repository

import com.example.weather.data.remote.response.Weather


interface WeatherRepository {
    suspend fun getWeather(key: String, city: String): Weather
}