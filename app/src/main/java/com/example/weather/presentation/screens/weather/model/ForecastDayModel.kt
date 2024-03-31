package com.example.weather.presentation.screens.weather.model

import com.example.weather.data.remote.response.ForecastDay

data class ForecastDayModel(
    val date: String,
    val temp: Int,
    val icon: String
)
fun ForecastDay.toForecastDayModel(): ForecastDayModel {
        return ForecastDayModel(this.date, this.day.avgTemp.toInt(), this.day.condition.icon)
}


