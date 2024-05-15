package com.example.weather.presentation.screens.city.manager

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CityManagerScreen(
    onNavigateToWeather: (String) -> Unit,
    navController: NavController,
    screenState: CityManagerState,
    getListCity: () -> Unit,
    deleteCity: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        getListCity()


        Button(
            onClick = { navController.navigate("citySearch") },
            modifier = Modifier.padding(5.dp).fillMaxWidth()

        ) {
            Text("Поиск")
        }

        screenState.listCity.forEach {
            Column{
                Row {
                    Button(
                        onClick = {
                            onNavigateToWeather(it.name)
                        }
                    ) {
                        Text(text=it.name)

                    }
                    Button(
                        onClick = {deleteCity(it.name)}
                    ) {
                        Text(text="delete")
                    }
                }
            }



        }
    }
}