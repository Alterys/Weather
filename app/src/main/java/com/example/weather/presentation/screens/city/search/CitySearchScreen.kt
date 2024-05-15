package com.example.weather.presentation.screens.city.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CitySearchScreen(
    onNavigateToWeather: (String) -> Unit,
    screenState: CitySearchState,
    searchCity: (String) -> Unit,
    addCity: (String) -> Unit,
    clearListCity: () -> Unit
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

        screenState.searchModel.forEach { searchModel ->
            TextButton(
                onClick = {
                    searchModel.city?.let {
                        addCity(it)
                        clearListCity()
                        onNavigateToWeather(it)
                    }
                }
            ) {
                Column {
                    searchModel.city?.let { city ->
                        Text(
                            text = city,
                            fontSize = 18.sp,
                        )
                    }
                    Row(
                        modifier = Modifier.padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        searchModel.region?.let { region ->
                            Text(
                                text = region,
                                fontSize = 12.sp,
                            )
                        }
                        Spacer(modifier = Modifier.width(3.dp))
                        searchModel.country?.let { country ->
                            Text(
                                text = country,
                                fontSize = 12.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}
