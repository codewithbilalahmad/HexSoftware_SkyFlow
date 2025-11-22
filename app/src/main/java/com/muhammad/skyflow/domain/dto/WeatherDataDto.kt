package com.muhammad.skyflow.domain.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataDto(
    @SerialName("base")
    val base: String?,
    @SerialName("clouds")
    val clouds: CloudsDto?,
    @SerialName("cod")
    val cod: Int?,
    @SerialName("coord")
    val coord: CoordDto?,
    @SerialName("dt")
    val dt: Int?,
    @SerialName("id")
    val id: Int?,
    @SerialName("main")
    val main: MainDto?,
    @SerialName("name")
    val name: String?,
    @SerialName("sys")
    val sys: SysDto?,
    @SerialName("timezone")
    val timezone: Int?,
    @SerialName("visibility")
    val visibility: Int?=null,
    @SerialName("weather")
    val weather: List<WeatherDto?>?,
    @SerialName("wind")
    val wind: WindDto?
)