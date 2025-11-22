package com.muhammad.skyflow.presentation.navigaton

import kotlinx.serialization.Serializable

sealed interface Destination {
    @Serializable
    data object HomeScreen : Destination
}