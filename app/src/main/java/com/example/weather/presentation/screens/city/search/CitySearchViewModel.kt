package com.example.weather.presentation.screens.city.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.common.Resource
import com.example.weather.domain.usecase.SearchCityUseCase
import com.example.weather.presentation.screens.city.search.model.toSearchModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class CitySearchViewModel: ViewModel() {

    private val _screenState = MutableStateFlow(CitySearchState())
    val screenState: StateFlow<CitySearchState> = _screenState

    fun searchCity(city: String) {
        if (city.length < 3) {
            return
        }
        SearchCityUseCase()(city).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _screenState.update { state ->
                        state.copy(
                            searchModel = result.data.map {it.toSearchModel()}
                        )
                    }
                }
                is Resource.Error -> {
                    _screenState.update {
                        it.copy(
                            isLoading = false
                        )
                    }
                }
                is Resource.Loading -> {
                    _screenState.update {
                        it.copy(
                            isLoading = true
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}