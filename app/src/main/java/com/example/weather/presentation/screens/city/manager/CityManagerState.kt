package com.example.weather.presentation.screens.city.manager

import com.example.weather.data.storage.cities.City

data class CityManagerState(
    val citySave: List<String> = emptyList(),
    val listCity: List<City> = emptyList(),
    val isLoading: Boolean = false,
)
