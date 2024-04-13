package com.example.weather.presentation.screens.weather

import com.example.weather.data.remote.response.Current
import com.example.weather.data.remote.response.Location
import com.example.weather.presentation.screens.weather.model.ForecastDayModel


data class  WeatherState(
    val weatherCurrent: Current? = null,
    val isLoading: Boolean = false,
    val forecastDay: List<ForecastDayModel>? = emptyList(),
    val location: Location? = null,
)

