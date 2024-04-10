package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.weather.presentation.screens.weather.WeatherScreen
import com.example.weather.presentation.screens.weather.WeatherViewModel
import com.example.weather.presentation.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val weatherViewModel: WeatherViewModel by viewModels()
                    val state = weatherViewModel.screenState.collectAsState().value
                    WeatherScreen(
                        screenState = state,
                        getWeather = weatherViewModel::getWeather,
                        searchCity = weatherViewModel::searchCity
                    )
                }
            }
        }
    }
}
