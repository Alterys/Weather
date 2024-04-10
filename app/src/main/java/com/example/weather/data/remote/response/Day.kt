package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Day(
    @SerializedName("maxtemp_c") val maxTemp: Double,
    @SerializedName("mintemp_c") val minTemp: Double,
    @SerializedName("condition") val condition: ForecastCondition
)
