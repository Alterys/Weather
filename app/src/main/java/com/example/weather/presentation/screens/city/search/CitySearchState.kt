package com.example.weather.presentation.screens.city.search

import com.example.weather.presentation.screens.city.search.model.SearchModel

data class CitySearchState(
    val searchModel: List<SearchModel> = emptyList(),
    val isLoading: Boolean = false,
)
