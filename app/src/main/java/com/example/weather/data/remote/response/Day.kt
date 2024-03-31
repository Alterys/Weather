package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("avgtemp_c") val avgTemp: Double,
    @SerializedName("condition") val condition: Condition
)
