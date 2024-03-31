package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("current") val current: Current,
    @SerializedName("forecast") val forecast: Forecast
)