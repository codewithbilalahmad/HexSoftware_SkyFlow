package com.muhammad.skyflow.data.service

import com.muhammad.skyflow.data.service.client.get
import com.muhammad.skyflow.domain.dto.WeatherDataDto
import com.muhammad.skyflow.domain.utils.Result
import com.muhammad.skyflow.utils.Constants.API_KEY
import io.ktor.client.HttpClient


class WeatherApiServiceImp(
    private val httpClient: HttpClient,
) : WeatherApiService {
    override suspend fun getWeatherData(city: String): Result<WeatherDataDto> {
        return httpClient.get(
            route = "weather",
            queryParameters = mapOf("q" to city, "appid" to API_KEY, "units" to "metric")
        )
    }
}