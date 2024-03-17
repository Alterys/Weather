package com.example.weather.presentation.screens.weather

import com.example.weather.data.remote.response.Current

data class WeatherState(
    val weatherForecast: Current? = null,
    val isLoading: Boolean = false
)

