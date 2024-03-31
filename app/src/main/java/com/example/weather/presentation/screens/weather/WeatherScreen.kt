package com.example.weather.presentation.screens.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import coil.compose.AsyncImage
import com.example.weather.R


@Composable
fun WeatherScreen(
    screenState: WeatherState,
    getWeather: (String) -> Unit,
    getForecast: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(28.dp)
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
                },
                singleLine = true,
                
                readOnly = screenState.isLoading
            )

            Spacer(modifier = Modifier.heightIn(60.dp))

            Button(
                onClick = {
                    getWeather(city)
                    getForecast(city)
                },
                enabled = !screenState.isLoading,
                modifier = Modifier
                    .padding(16.dp)
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
            Spacer(modifier = Modifier.heightIn(60.dp))
            screenState.forecastDay?.get(1)?.date?.let {
                Text(
                    text = it,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.heightIn(60.dp))
            screenState.forecastDay?.get(1)?.temp?.let {
                Text(
                    text = it.toString(),
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.heightIn(60.dp))
            screenState.forecastDay?.get(1)?.icon?.let {
                val imageIrl = "https://$it"
                AsyncImage(
                    model = imageIrl,
                    contentDescription = null,
                    modifier = Modifier
                        .width(300.dp)
                        .height(300.dp)
                )
            }



        }
    }
}


