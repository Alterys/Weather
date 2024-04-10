package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Current (
    @SerializedName("temp_c") val temp: Double,
    @SerializedName("condition") val condition: CurrentCondition,
)