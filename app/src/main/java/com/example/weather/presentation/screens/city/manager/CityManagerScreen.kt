package com.example.weather.presentation.screens.city.manager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CityManagerScreen(
    navController: NavController,
    screenState: CityManagerState,
) {
    Column {
        Button(
            onClick = { navController.navigate("citySearch") },
            modifier = Modifier.width(OutlinedTextFieldDefaults.MinWidth)
                .height(OutlinedTextFieldDefaults.MinHeight)
        ) {
            Text("Поиск")
        }
    }
}