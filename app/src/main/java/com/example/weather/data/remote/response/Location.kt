package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") val nameLocation: String
)
