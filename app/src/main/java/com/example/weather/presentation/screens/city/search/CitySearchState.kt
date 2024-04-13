package com.example.weather.presentation.screens.city.search

data class CitySearchState(
    val city: Set<String> = emptySet(),
    val isLoading: Boolean = false,
)
