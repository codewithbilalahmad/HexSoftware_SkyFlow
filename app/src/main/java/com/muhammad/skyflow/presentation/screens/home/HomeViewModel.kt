package com.muhammad.skyflow.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammad.skyflow.domain.repository.WeatherRepository
import com.muhammad.skyflow.domain.utils.onError
import com.muhammad.skyflow.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        onAction(HomeAction.GetWeatherData)
    }

    fun onAction(action: HomeAction) {
        when (action) {
            is HomeAction.GetWeatherData -> getWeatherData()
            is HomeAction.OnSearchChange -> {
                _state.update { it.copy(searchQuery = action.search) }
            }
        }
    }

    private fun getWeatherData() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isWeatherLoading = true,
                    weatherError = null,
                    failedToLoadWeather = false,
                    location = _state.value.searchQuery
                )
            }
            weatherRepository.getWeatherData(city = _state.value.searchQuery).onSuccess { data ->
                _state.update {
                    it.copy(
                        isWeatherLoading = false,
                        weatherError = null,
                        failedToLoadWeather = false,
                        weatherData = data
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        isWeatherLoading = false,
                        weatherError = error,
                        failedToLoadWeather = true
                    )
                }
            }
        }
    }
}