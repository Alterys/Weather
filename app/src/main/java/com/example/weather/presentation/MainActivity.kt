package com.example.weather.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weather.presentation.screens.city.manager.CityManagerScreen
import com.example.weather.presentation.screens.city.manager.CityManagerViewModel
import com.example.weather.presentation.screens.city.search.CitySearchScreen
import com.example.weather.presentation.screens.city.search.CitySearchViewModel
import com.example.weather.presentation.screens.weather.WeatherScreen
import com.example.weather.presentation.screens.weather.WeatherViewModel
import com.example.weather.presentation.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val weatherViewModel: WeatherViewModel by viewModels()
                    val cityManagerViewModel: CityManagerViewModel by viewModels()
                    val stateCityManager = cityManagerViewModel.screenState.collectAsState().value
                    val stateWeather = weatherViewModel.screenState.collectAsState().value
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "cityManager"
                    ) {
                        composable(
                            route = "cityManager"
                        ) {
                            CityManagerScreen(
                                onNavigateToWeather = { navController.navigate("weather/$it") },
                                navController = navController,
                                screenState = stateCityManager,
                                getListCity = cityManagerViewModel::getListCity,
                                deleteCity = cityManagerViewModel::deleteCity
                            )
                        }
                        composable(
                            route = "citySearch",
                            ) {
                            val citySearchViewModel: CitySearchViewModel by viewModels()
                            CitySearchScreen(
                                onNavigateToWeather = {
                                    navController.navigate("weather/$it") {

                                        popUpTo("citySearch") {
                                            inclusive = true
                                        }
                                    }
                                },
                                screenState = citySearchViewModel.screenState.collectAsState().value,
                                searchCity = citySearchViewModel::searchCity,
                                addCity = citySearchViewModel::addCity,
                                clearListCity = citySearchViewModel::clearListCity
                            )
                        }
                        composable(
                            route = "weather/{city}",
                            arguments = listOf(navArgument("city") { type = NavType.StringType })
                        ) {
                            val city = it.arguments?.getString("city") ?: ""
                            WeatherScreen(
                                city = city,
                                navController = navController,
                                screenState = stateWeather,
                                getWeather = weatherViewModel::getWeather,
                            )

                        }
                    }
                }
            }
        }
    }
}
