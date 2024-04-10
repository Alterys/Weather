package com.example.weather.domain.repository

import com.example.weather.data.remote.response.Weather
import com.example.weather.data.remote.response.search.Search


interface WeatherRepository {
    suspend fun getWeather(city: String): Weather
    suspend fun searchCity(city: String): List<Search>
}