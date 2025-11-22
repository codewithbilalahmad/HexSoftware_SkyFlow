package com.muhammad.skyflow.domain.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindDto(
    @SerialName("deg")
    val deg: Int?,
    @SerialName("gust")
    val gust: Double?=null,
    @SerialName("speed")
    val speed: Double?
)