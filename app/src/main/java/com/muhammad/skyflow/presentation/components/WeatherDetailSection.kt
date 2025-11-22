package com.muhammad.skyflow.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import com.muhammad.skyflow.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.muhammad.skyflow.presentation.theme.TranslucentWhite
import com.muhammad.skyflow.utils.convertToKmh
import com.muhammad.skyflow.utils.convertUnixToLocalTime

@Composable
fun WeatherDetailSection(
    modifier: Modifier = Modifier,
    humanity: Int,
    windSpeed: Double, timeZoneOffset: Int,
    feelsLike: Double,
    sunrise: Int,
    sunset: Int,
    seaLevel: Int,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = TranslucentWhite),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDetailItem(
                    label = R.string.humidity,
                    value = "$humanity%",
                    icon = R.drawable.humidity
                )
                WeatherDetailItem(
                    label = R.string.wind_speed,
                    value = convertToKmh(windSpeed),
                    icon = R.drawable.wind_speed
                )
                WeatherDetailItem(
                    label = R.string.feels_like,
                    value = "$feelsLike°C",
                    icon = R.drawable.feels_like
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherDetailItem(
                    label = R.string.sun_rise,
                    value = convertUnixToLocalTime(
                        unixTimeStamp = sunrise.toLong(),
                        timezoneOffset = timeZoneOffset
                    ),
                    icon = R.drawable.sunrise
                )
                WeatherDetailItem(
                    label = R.string.sun_set,
                    value = convertUnixToLocalTime(
                        unixTimeStamp = sunset.toLong(),
                        timezoneOffset = timeZoneOffset
                    ),
                    icon = R.drawable.sunset
                )
                WeatherDetailItem(
                    label = R.string.sea_level,
                    value = "$seaLevel hPa",
                    icon = R.drawable.sea
                )
            }
        }
    }
}
