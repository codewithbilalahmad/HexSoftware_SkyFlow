package com.muhammad.skyflow.di

import com.muhammad.skyflow.data.repository.WeatherRepositoryImp
import com.muhammad.skyflow.data.service.WeatherApiService
import com.muhammad.skyflow.data.service.WeatherApiServiceImp
import com.muhammad.skyflow.data.service.client.HttpClientFactory
import com.muhammad.skyflow.domain.repository.WeatherRepository
import com.muhammad.skyflow.presentation.screens.home.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.createWeatherClient() }
    single { WeatherApiServiceImp(get()) }.bind<WeatherApiService>()
    single { WeatherRepositoryImp(get()) }.bind<WeatherRepository>()
    viewModelOf(::HomeViewModel)
}