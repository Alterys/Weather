package com.example.weather.presentation.screens.weather.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WeatherImage(url: String) {
    val imageIrl = "https://$url"
    AsyncImage(
        model = imageIrl,
        contentDescription = null,
        modifier = Modifier
            .width(64.dp)
            .height(64.dp)
    )
}