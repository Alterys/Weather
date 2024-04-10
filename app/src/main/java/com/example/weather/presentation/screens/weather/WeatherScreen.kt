package com.example.weather.presentation.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.R
import com.example.weather.presentation.screens.weather.components.WeatherImage


@Composable
fun WeatherScreen(
    screenState: WeatherState,
    getWeather: (String) -> Unit,
    searchCity: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White
            )
            .padding(10.dp)
    ) {


        var city by remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxSize()) {

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = city,
                keyboardOptions = KeyboardOptions.Default,
                keyboardActions = KeyboardActions(),
                onValueChange = {
                    city = it
                    searchCity(city)
                },
                singleLine = true,
                readOnly = false
            )
            if (city.length >= 3) {

                Text(
                    text = city.length.toString()
                )
                Text(
                    text = screenState.city.toString()
                )
            }

            Spacer(modifier = Modifier.heightIn(60.dp))
            Button(
                onClick = {
                    getWeather(city)
                },
                modifier = Modifier
                    .padding(5.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.button_search)
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
                screenState.forecastDay?.forEachIndexed { _, forecastDay ->
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
