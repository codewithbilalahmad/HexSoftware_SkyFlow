package com.muhammad.skyflow.domain.repository

import com.muhammad.skyflow.domain.model.WeatherData
import com.muhammad.skyflow.domain.utils.Result

interface WeatherRepository {
    suspend fun getWeatherData(city : String) : Result<WeatherData>
}