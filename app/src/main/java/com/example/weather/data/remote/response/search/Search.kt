package com.example.weather.data.remote.response.search

import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("name") val nameSearch: String
)
