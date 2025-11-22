package com.muhammad.skyflow.presentation.screens.home

sealed interface HomeAction{
    data object GetWeatherData : HomeAction
    data class OnSearchChange(val search : String) : HomeAction
}