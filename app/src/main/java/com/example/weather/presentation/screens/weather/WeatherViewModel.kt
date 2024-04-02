package com.example.weather.presentation.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.common.Resource
import com.example.weather.domain.usecase.GetForecastDayUseCase
import com.example.weather.domain.usecase.GetWeatherUseCase
import com.example.weather.presentation.screens.weather.model.toForecastDayModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class WeatherViewModel: ViewModel() {

    private val _screenState = MutableStateFlow(WeatherState())
    val screenState: StateFlow<WeatherState> = _screenState

    fun getWeather(city: String) {
        GetWeatherUseCase()(city).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _screenState.update {
                        it.copy(
                            weatherCurrent = result.data.current,
                            isLoading = false
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
    fun getForecast(city: String) {
        GetForecastDayUseCase()(city).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _screenState.update {state ->
                        state.copy(
                            forecastDay = result.data.forecastday.map {it.toForecastDayModel()},
                            isLoading = false
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