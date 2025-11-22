package com.muhammad.skyflow.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

fun getTodayDate() : String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    return dateFormat.format(calendar.time)
}

fun getTodayDay() : String{
    val calendar = Calendar.getInstance()
    val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())
    return dayFormat.format(calendar.time)
}

@SuppressLint("NewApi")
fun convertUnixToLocalTime(unixTimeStamp : Long, timezoneOffset : Int) : String{
    val instant = Instant.ofEpochSecond(unixTimeStamp)
    val zoneOffset = ZoneOffset.ofTotalSeconds(timezoneOffset)
    val formatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.getDefault())
    return instant.atOffset(zoneOffset).format(formatter)
}

fun convertToKmh(speed : Double) : String {
    return "${(speed * 3.6).toInt()} km/h"
}

fun convertToKM(meters : Int) : String{
    return "${meters / 1000} km"
}



