package com.example.weather.presentation.screens.city.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CitySearchScreen(
    onNavigateToWeather: (String) -> Unit,
    screenState: CitySearchState,
    searchCity: (String) -> Unit
) {
    var city by remember {
        mutableStateOf("")
    }
    Column {
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

        screenState.city.forEach { city ->
            TextButton(
                onClick = { onNavigateToWeather(city) }
            ) {
                Text(text = city)
            }
        }
    }
}
