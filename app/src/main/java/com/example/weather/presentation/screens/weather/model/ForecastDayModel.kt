package com.example.weather.presentation.screens.weather.model

import com.example.weather.data.remote.response.ForecastDay

data class ForecastDayModel(
    val date: String,
    val minTemp: Double,
    val maxTemp: Double,
    val icon: String,
    val textCondition: String
)
fun ForecastDay.toForecastDayModel(): ForecastDayModel {
        return ForecastDayModel(
            this.date,
            this.day.minTemp,
            this.day.maxTemp,
            this.day.condition.icon,
            this.day.condition.textForecastCondition
        )
}


