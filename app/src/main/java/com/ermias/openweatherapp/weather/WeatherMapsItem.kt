package com.ermias.openweatherapp.weather

data class WeatherMapsItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)