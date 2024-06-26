package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("day") val day: Day
)