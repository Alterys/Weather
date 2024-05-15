package com.example.weather.data.repository

import com.example.weather.common.Constants.API_KEY
import com.example.weather.common.Constants.DAYS
import com.example.weather.data.remote.response.Weather
import com.example.weather.data.remote.response.search.Search
import com.example.weather.domain.repository.WeatherRepository
import androidx.compose.ui.text.intl.Locale
import com.example.weather.data.remote.WeatherApi
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {


    override suspend fun getWeather(city: String): Weather {
        val locale = Locale.current.language
        return api.getWeather(
            API_KEY,
            city,
            DAYS,
            locale
        )
    }

    override suspend fun searchCity(city: String): List<Search> {
        return api.searchCity(
            API_KEY,
            city
        )
    }
}