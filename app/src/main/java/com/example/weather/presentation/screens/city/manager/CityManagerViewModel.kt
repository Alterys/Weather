package com.example.weather.presentation.screens.city.manager

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.common.Resource
import com.example.weather.domain.usecase.AddCityUseCase
import com.example.weather.domain.usecase.DeleteCityUseCase
import com.example.weather.domain.usecase.GetListCityUseCase
import com.example.weather.presentation.screens.weather.model.toForecastDayModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CityManagerViewModel @Inject constructor(
    private val deleteCityUseCase: DeleteCityUseCase,
    private val getListCityUseCase: GetListCityUseCase
) : ViewModel() {

    private val _screenState = MutableStateFlow(CityManagerState())
    val screenState: StateFlow<CityManagerState> = _screenState

    fun deleteCity(name: String) {
        deleteCityUseCase(name).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _screenState.update {
                        it.copy(
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


    fun getListCity() {
        getListCityUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _screenState.update { state ->
                        state.copy(
                            listCity = result.data
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
