package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class ForecastCondition(
    @SerializedName("icon") val icon: String,
    @SerializedName("text") val textForecastCondition: String
)
