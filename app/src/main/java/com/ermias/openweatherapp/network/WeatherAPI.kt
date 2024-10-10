package com.ermias.openweatherapp.network

import com.ermias.openweatherapp.weather.WeatherMaps
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("direct")
    suspend fun getWeatherByCityName(
        @Query("q") city: String,
        @Query("limit") limit: String = "5",
        @Query("appid") apiKey: String
    ): Response<WeatherMaps>


    @GET("direct")
    suspend fun getWeatherByCityNameAndCountry(
        @Query("q") city: String,
        @Query(",") countryCode: String,
        @Query("limit") limit: String = "5",
        @Query("appid") apiKey: String
    ): Response<WeatherMaps>


    @GET("direct")
    suspend fun getWeatherByCityNameAndStateAndCountry(
        @Query("q") city: String,
        @Query(",") stateCode: String,
        @Query(",") countryCode: String = "US",
        @Query("limit") limit: String = "5",
        @Query("appid") apiKey: String
    ): Response<WeatherMaps>
}