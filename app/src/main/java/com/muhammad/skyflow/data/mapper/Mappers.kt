package com.muhammad.skyflow.data.mapper

import com.muhammad.skyflow.domain.dto.CloudsDto
import com.muhammad.skyflow.domain.dto.CoordDto
import com.muhammad.skyflow.domain.dto.MainDto
import com.muhammad.skyflow.domain.dto.SysDto
import com.muhammad.skyflow.domain.dto.WeatherDataDto
import com.muhammad.skyflow.domain.dto.WeatherDto
import com.muhammad.skyflow.domain.dto.WindDto
import com.muhammad.skyflow.domain.model.Clouds
import com.muhammad.skyflow.domain.model.Coord
import com.muhammad.skyflow.domain.model.Main
import com.muhammad.skyflow.domain.model.Sys
import com.muhammad.skyflow.domain.model.Weather
import com.muhammad.skyflow.domain.model.WeatherData
import com.muhammad.skyflow.domain.model.Wind
import com.muhammad.skyflow.domain.utils.orEmpty

fun CloudsDto?.toCloud(): Clouds {
    return Clouds(all = this?.all ?: 0)
}

fun CoordDto?.toCoord(): Coord {
    return Coord(
        lat = this?.lat.orEmpty(), lon = this?.lon.orEmpty()
    )
}

fun MainDto?.toMain(): Main {
    return Main(
        feelsLike = this?.feelsLike.orEmpty(),
        grndLevel = this?.grndLevel.orEmpty(),
        humidity = this?.humidity.orEmpty(),
        pressure = this?.pressure.orEmpty(),
        seaLevel = this?.seaLevel.orEmpty(),
        temp = this?.temp.orEmpty(),
        tempMax = this?.tempMax.orEmpty(),
        tempMin = this?.tempMin.orEmpty()
    )
}

fun SysDto?.toSys(): Sys {
    return Sys(
        country = this?.country.orEmpty(), sunset = this?.sunset.orEmpty(), sunrise = this?.sunrise.orEmpty()
    )
}

fun WeatherDto?.toWeather(): Weather {
    return Weather(
        description = this?.description.orEmpty(),
        icon = this?.icon.orEmpty(),
        id = this?.id.orEmpty(),
        main = this?.main.orEmpty()
    )
}

fun WindDto?.toWind(): Wind {
    return Wind(deg = this?.deg.orEmpty(), speed = this?.speed.orEmpty(), gust = this?.gust.orEmpty())
}

fun WeatherDataDto.toWeatherData(): WeatherData {
    return WeatherData(
        base = base.orEmpty(),
        clouds = clouds.toCloud(),
        cod = cod.orEmpty(),
        coord = coord.toCoord(),
        dt = dt.orEmpty(),
        id = id.orEmpty(),
        main = main.toMain(),
        name = name.orEmpty(),
        sys = sys.toSys(),
        timezone = timezone.orEmpty(),
        visibility = visibility.orEmpty(),
        weather = weather?.map { it.toWeather() } ?: emptyList(),
        wind = wind.toWind()
    )
}
