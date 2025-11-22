package com.muhammad.skyflow.presentation.screens.home

import androidx.compose.foundation.text.input.TextFieldState
import com.muhammad.skyflow.domain.model.WeatherData

data class HomeState(
    val isWeatherLoading : Boolean = false,
    val weatherData: WeatherData?=null,
    val searchQuery : String = "Talagang",
    val location : String = "Talagang",
    val failedToLoadWeather : Boolean = false,
    val weatherError : String? = null
)