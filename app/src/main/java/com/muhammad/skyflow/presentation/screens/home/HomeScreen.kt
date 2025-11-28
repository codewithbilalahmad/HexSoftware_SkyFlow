package com.muhammad.skyflow.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ContainedLoadingIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.toShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.muhammad.skyflow.R
import com.muhammad.skyflow.presentation.components.AppTextField
import com.muhammad.skyflow.presentation.components.WeatherDetailSection
import com.muhammad.skyflow.presentation.components.WeatherStatsSection
import com.muhammad.skyflow.utils.convertToKM
import com.muhammad.skyflow.utils.getTodayDate
import com.muhammad.skyflow.utils.getTodayDay
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen() {
    val viewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(
                when (state.weatherData?.weather?.firstOrNull()?.main) {
                    "Clear" -> R.drawable.sunny_background
                    "Clouds" -> R.drawable.cloud_background
                    "Rain", "Drizzle" -> R.drawable.rain_background
                    "Thunderstorm" -> R.drawable.thunder_background
                    "Snow" -> R.drawable.snow_background
                    "Smoke" -> R.drawable.smoke_background
                    "Mist", "Haze", "Dust", "Fog", "Sand", "Ash", "Squall", "Tornado" -> R.drawable.mist_background
                    else -> R.drawable.sunny_background
                }
            ), contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item("search_bar") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .statusBarsPadding(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = MaterialShapes.Cookie9Sided.toShape()
                            ), contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.skyflow),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    }
                    AppTextField(
                        value = state.searchQuery, onValueChange = { newValue ->
                            viewModel.onAction(HomeAction.OnSearchChange(newValue))
                        },
                        modifier = Modifier.weight(1f),
                        leadingIcon = R.drawable.ic_search,
                        hint = R.string.search, onKeyboardAction = {
                            viewModel.onAction(HomeAction.GetWeatherData)
                        }
                    )
                }
            }
            when {
                state.weatherData != null && !state.isWeatherLoading && state.weatherError == null -> {
                    state.weatherData?.let { data ->
                        item("location_section") {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                horizontalArrangement = Arrangement.spacedBy(
                                    6.dp,
                                    Alignment.CenterHorizontally
                                ), verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    modifier = Modifier.size(22.dp),
                                    imageVector = ImageVector.vectorResource(R.drawable.location),
                                    contentDescription = null
                                )
                                Text(
                                    text = state.location,
                                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
                                )
                            }
                        }
                        item("weather_stats_section") {
                            WeatherStatsSection(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 16.dp),
                                weatherIcon = when (data.weather.first().main) {
                                    "Clear" -> R.drawable.sun
                                    "Clouds" -> R.drawable.cloud
                                    "Rain", "Drizzle" -> R.drawable.rain
                                    "Thunderstorm" -> R.drawable.thunder
                                    "Snow" -> R.drawable.snow
                                    "Smoke" -> R.drawable.smoke
                                    "Mist", "Haze", "Dust", "Fog", "Sand", "Ash", "Squall", "Tornado" -> R.drawable.mist
                                    else -> R.drawable.sun
                                },
                                temperature = data.main.temp,
                                minTemperature = data.main.tempMin,
                                maxTemperature = data.main.tempMax,
                                weatherType = data.weather.first().main
                            )
                        }
                        item("weather_date_section") {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Text(
                                    text = "${stringResource(R.string.visibility)} : ${
                                        convertToKM(
                                            data.visibility
                                        )
                                    }",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "${stringResource(R.string.air_pressure)} : ${data.main.pressure} hPa",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = getTodayDay(),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = getTodayDate(),
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                        item("weather_detail_section") {
                            WeatherDetailSection(
                                humanity = data.main.humidity,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 16.dp),
                                windSpeed = data.wind.speed,
                                feelsLike = data.main.feelsLike,
                                sunset = data.sys.sunset,
                                sunrise = data.sys.sunrise,
                                seaLevel = data.main.seaLevel, timeZoneOffset = data.timezone
                            )
                        }
                    }
                }

                state.isWeatherLoading -> {
                    item("loading_section") {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            ContainedLoadingIndicator()
                        }
                    }
                }

                !state.isWeatherLoading && state.weatherError != null -> {
                    item("error_section") {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(R.drawable.error),
                                contentDescription = null, tint = Color.Unspecified,
                                modifier = Modifier.size(120.dp)
                            )
                            state.weatherError?.let { error ->
                                Text(
                                    text = error,
                                    style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}