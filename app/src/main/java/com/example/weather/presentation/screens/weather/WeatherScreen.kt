package com.example.weather.presentation.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weather.presentation.screens.weather.components.WeatherImage


@Composable
fun WeatherScreen(
    city: String,
    navController: NavController,
    screenState: WeatherState,
    getWeather: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White
            )
            .padding(10.dp)
    ) {
        getWeather(city)


        Column(modifier = Modifier.fillMaxSize()) {
            Row {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "icon",
                    modifier = Modifier
                        .height(28.dp)
                        .width(28.dp)
                        .padding(bottom = 4.dp)
                        .clickable { navController.navigate("cityManager") }
                )
                Text(
                    text = city
                )
            }
            Spacer(modifier = Modifier.heightIn(60.dp))
            screenState.weatherCurrent?.temp?.let {
                Text(
                    text = "$it°C",
                    fontSize = 32.sp
                )
            }
            screenState.weatherCurrent?.condition?.textCurrentCondition?.let {
                Text(
                    text = it,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.heightIn(60.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                screenState.forecastDay?.forEach { forecastDay ->
                    Column(
                        modifier = Modifier.padding(5.dp)
                    ) {
                        Text(
                            text = forecastDay.textCondition,
                            fontSize = 12.sp
                        )
                        Text(
                            text = forecastDay.date,
                            fontSize = 12.sp
                        )
                        val minTemp: Int = forecastDay.maxTemp.toInt()
                        val maxTemp: Int = forecastDay.minTemp.toInt()
                        Text(
                            text = "$maxTemp° / $minTemp°",
                            fontSize = 18.sp
                        )
                        WeatherImage(forecastDay.icon)
                    }
                }
            }
        }
    }
}
