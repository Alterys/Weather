package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("icon") val icon: String
)
