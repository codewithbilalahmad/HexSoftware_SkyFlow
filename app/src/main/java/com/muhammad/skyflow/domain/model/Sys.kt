package com.muhammad.skyflow.domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Sys(
    val country: String,
    val sunrise: Int,
    val sunset: Int
)