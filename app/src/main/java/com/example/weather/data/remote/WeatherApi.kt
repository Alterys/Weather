package com.example.weather.data.remote

import com.example.weather.data.remote.response.Weather
import com.example.weather.data.remote.response.search.Search
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int,
        @Query("lang") lang: String
    ): Weather

    @GET("search.json")
    suspend fun searchCity(
        @Query("key") key: String,
        @Query("q") q: String
    ): List<Search>
}