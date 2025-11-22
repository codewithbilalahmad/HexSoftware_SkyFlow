package com.muhammad.skyflow.domain.utils

fun Double?.orEmpty() : Double{
    return this ?: 0.0
}

fun Int?.orEmpty() : Int{
    return this ?: 0
}