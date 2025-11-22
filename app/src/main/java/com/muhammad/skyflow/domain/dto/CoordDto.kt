package com.muhammad.skyflow.domain.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordDto(
    @SerialName("lat")
    val lat: Double?,
    @SerialName("lon")
    val lon: Double?
)