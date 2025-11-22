package com.muhammad.skyflow.domain.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainDto(
    @SerialName("feels_like")
    val feelsLike: Double?,
    @SerialName("grnd_level")
    val grndLevel: Int?,
    @SerialName("humidity")
    val humidity: Int?,
    @SerialName("pressure")
    val pressure: Int?,
    @SerialName("sea_level")
    val seaLevel: Int?,
    @SerialName("temp")
    val temp: Double?,
    @SerialName("temp_max")
    val tempMax: Double?,
    @SerialName("temp_min")
    val tempMin: Double?
)