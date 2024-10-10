package com.ermias.openweatherapp

import com.ermias.openweatherapp.network.WeatherAPI
import com.ermias.openweatherapp.weather.WeatherMaps
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class Repository @Inject constructor(private val weatherAPI: WeatherAPI) {
    suspend fun getByCityName(city: String, apiKey: String): WeatherMaps =
        withContext(Dispatchers.IO) {
            val response = weatherAPI.getWeatherByCityName(city, "5",apiKey)
            if (response.isSuccessful) {
                return@withContext response.body() as WeatherMaps
            }
            val weatherMaps = WeatherMaps()
            return@withContext weatherMaps
        }

    suspend fun getByCityNameAndCountryCode(city: String,countryCode: String, apiKey: String): WeatherMaps =
        withContext(Dispatchers.IO) {
            val response = weatherAPI.getWeatherByCityNameAndCountry(city, countryCode,"5",apiKey)
            if (response.isSuccessful) {
                return@withContext response.body() as WeatherMaps
            }
            val weatherMaps = WeatherMaps()
            return@withContext weatherMaps
        }

    suspend fun getByCityNameAndStateAndCountryCode(city: String,
                                                    stateCode: String, apiKey: String): WeatherMaps
    =withContext(Dispatchers.IO) {
            val response = weatherAPI.getWeatherByCityNameAndStateAndCountry(city,
                stateCode,"US","5",apiKey)
            if (response.isSuccessful) {
                return@withContext response.body() as WeatherMaps
            }
            val weatherMaps = WeatherMaps()
            return@withContext weatherMaps
        }
}