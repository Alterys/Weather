package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentCondition(
    @SerializedName("text") val textCurrentCondition: String
)
