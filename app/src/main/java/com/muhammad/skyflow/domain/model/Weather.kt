package com.muhammad.skyflow.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)