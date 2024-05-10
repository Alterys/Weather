package com.example.weather.domain.usecase

import com.example.weather.common.Resource
import com.example.weather.data.remote.response.Weather
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWeatherUseCase(
    private val repository: WeatherRepository = WeatherRepositoryImpl
) {
    operator fun invoke(city: String): Flow<Resource<Weather>> = flow {
        try {
            emit(Resource.Loading)
            val response = repository.getWeather(city)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            e.printStackTrace()
        }
    }
}