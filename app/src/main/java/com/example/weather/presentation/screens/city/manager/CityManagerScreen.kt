package com.example.weather.presentation.screens.city.manager

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CityManagerScreen(
    navController: NavController,
) {
    Button(
        onClick = { navController.navigate("citySearch")},
        modifier = Modifier
    ) {
        Text("Поиск")
    }
}