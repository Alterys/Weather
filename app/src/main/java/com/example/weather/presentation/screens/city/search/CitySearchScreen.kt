package com.example.weather.presentation.screens.city.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.weather.R

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
            onClick = { if (screenState.city.toString().isNotEmpty()) { onNavigateToWeather(city) } },
            modifier = Modifier.padding(20.dp)
        ) {
            Text(text = stringResource(id = R.string.button_search))
        }
    }
}
