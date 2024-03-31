package com.example.weather.data.remote

import com.example.weather.data.remote.response.Weather
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int
    ): Weather
}