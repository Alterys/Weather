package com.example.weather.data.remote.response

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday") val forecastday: List<ForecastDay>

)