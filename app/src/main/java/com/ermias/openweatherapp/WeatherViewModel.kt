package com.ermias.openweatherapp

import androidx.lifecycle.ViewModel
import com.ermias.openweatherapp.weather.WeatherMaps
import com.ermias.openweatherapp.weather.WeatherMapsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Locale.IsoCountryCode
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: Repository) : ViewModel(){
    private val _weatherByCityName = MutableStateFlow(WeatherMaps())
    private val _weatherByCityNameAndCountryCode = MutableStateFlow(WeatherMaps())
    private val _weatherByCityNameAndStateAndCountryCode = MutableStateFlow(WeatherMaps())

    val weatherByCityName: MutableStateFlow<WeatherMaps> = _weatherByCityName
    val weatherByCityNameAndCountryCode: MutableStateFlow<WeatherMaps> =
        _weatherByCityNameAndCountryCode
    val weatherByCityNameAndStateAndCountryCode: MutableStateFlow<WeatherMaps> =
        _weatherByCityNameAndStateAndCountryCode

    suspend fun getWeatherByCityName(city: String, apiKey: String) {
        val weather = repository.getByCityName(city, apiKey)
        _weatherByCityName.value = weather
    }

    suspend fun getWeatherByCityNameAndCountryCode(city: String, countryCode: String,
                                                   apiKey: String) {
        val weather = repository.getByCityNameAndCountryCode(city, countryCode, apiKey)
        _weatherByCityNameAndCountryCode.value = weather
    }
    suspend fun getWeatherByCityNameAndStateAndCountryCode(city: String, stateCode: String
                                                           ,apiKey: String) {
        val weather = repository.getByCityNameAndStateAndCountryCode(city, stateCode, apiKey)
        _weatherByCityNameAndStateAndCountryCode.value = weather
    }

}