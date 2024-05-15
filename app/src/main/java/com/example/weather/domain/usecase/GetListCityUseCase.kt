package com.example.weather.domain.usecase

import android.content.Context
import android.util.Log
import com.example.weather.common.Resource
import com.example.weather.data.repository.CityStorageRepositoryImpl
import com.example.weather.data.storage.cities.City
import com.example.weather.domain.repository.CityStorageRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetListCityUseCase @Inject constructor(
    private val repository: CityStorageRepository
) {
    operator fun invoke(): Flow<Resource<List<City>>> = flow {
        try {
            emit(Resource.Loading)
            val response = repository.getListCity()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            e.printStackTrace()
        }
    }
}