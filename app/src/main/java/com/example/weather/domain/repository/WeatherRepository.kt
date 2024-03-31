package com.example.weather.domain.repository

import com.example.weather.data.remote.response.Weather


interface WeatherRepository {
    suspend fun getWeather(city: String): Weather
}