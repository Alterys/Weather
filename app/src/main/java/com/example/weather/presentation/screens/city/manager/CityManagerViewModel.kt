package com.example.weather.presentation.screens.city.manager

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CityManagerViewModel: ViewModel() {

    private val _screenState = MutableStateFlow(CityManagerState())
    val screenState: StateFlow<CityManagerState> = _screenState
}