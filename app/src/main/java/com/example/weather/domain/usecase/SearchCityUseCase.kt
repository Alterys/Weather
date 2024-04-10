package com.example.weather.domain.usecase

import android.util.Log
import com.example.weather.common.Resource
import com.example.weather.data.remote.response.search.Search
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchCityUseCase(
    private val repository: WeatherRepository = WeatherRepositoryImpl
) {
    operator fun invoke(city: String): Flow<Resource<List<Search>>> = flow {
        try {
            emit(Resource.Loading)
            val response = repository.searchCity(city)
            emit(Resource.Success(response))
            Log.d("NEGR", response.toString())
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            e.printStackTrace()
        }
    }
}