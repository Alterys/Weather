package com.example.weather.domain.usecase

import com.example.weather.common.Resource
import com.example.weather.domain.repository.CityStorageRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DeleteCityUseCase @Inject constructor(
    private val repository: CityStorageRepository
) {
    operator fun invoke(nameCity: String) = flow {
        try {
            emit(Resource.Loading)
            val response = repository.deleteCityByName(nameCity)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error"))
            e.printStackTrace()
        }
    }
}