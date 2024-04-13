package com.example.weather.presentation.screens.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.common.Resource
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
                    _screenState.update {state ->
                        state.copy(
                            weatherCurrent = result.data.current,
                            location = result.data.location,
                            forecastDay = result.data.forecast.forecastday.map {it.toForecastDayModel()},
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