package com.muhammad.skyflow.data.service

import com.muhammad.skyflow.domain.dto.WeatherDataDto
import com.muhammad.skyflow.domain.utils.Result

interface WeatherApiService{
    suspend fun getWeatherData(city : String) : Result<WeatherDataDto>
}