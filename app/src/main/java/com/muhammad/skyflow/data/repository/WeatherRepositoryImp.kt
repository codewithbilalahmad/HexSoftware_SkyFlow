package com.muhammad.skyflow.data.repository

import com.muhammad.skyflow.data.mapper.toWeatherData
import com.muhammad.skyflow.data.service.WeatherApiService
import com.muhammad.skyflow.domain.model.WeatherData
import com.muhammad.skyflow.domain.repository.WeatherRepository
import com.muhammad.skyflow.domain.utils.Result
import com.muhammad.skyflow.domain.utils.map

class WeatherRepositoryImp(
    private val weatherApiService: WeatherApiService
) : WeatherRepository{
    override suspend fun getWeatherData(city: String): Result<WeatherData> {
        return weatherApiService.getWeatherData(city).map { it.toWeatherData() }
    }
}