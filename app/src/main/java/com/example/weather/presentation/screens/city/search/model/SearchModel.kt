package com.example.weather.presentation.screens.city.search.model

import com.example.weather.data.remote.response.search.Search

data class SearchModel(
    val city: String? = null,
    val region: String? = null,
    val country: String? = null
)

fun Search.toSearchModel(): SearchModel {
    return SearchModel(this.nameSearch, this.regionSearch, this.countrySearch )
}