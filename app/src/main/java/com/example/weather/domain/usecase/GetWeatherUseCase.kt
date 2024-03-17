package com.example.weather.domain.usecase

import android.util.Log
import com.example.weather.common.Resource
import com.example.weather.data.remote.response.Current
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class GetWeatherUseCase(
    private val repository: WeatherRepository = WeatherRepositoryImpl
) {
    operator fun invoke(key: String, city: String): Flow<Resource<Current>> = flow {
        try {
            emit(Resource.Loading)
            val response = repository.getWeather(key, city).current
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            e.printStackTrace()
        }
    }

}