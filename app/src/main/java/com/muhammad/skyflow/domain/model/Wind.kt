package com.muhammad.skyflow.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)