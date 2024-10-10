package com.ermias.openweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ermias.openweatherapp.composable.WeatherNav
import com.ermias.openweatherapp.ui.theme.OpenWeatherAppTheme
import com.ermias.openweatherapp.weather.WeatherAccessKey
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenWeatherAppTheme {
                WeatherNav(weatherViewModel)
                /*LaunchedEffect(1) {
                    weatherViewModel.getWeatherByCityName("London", WeatherAccessKey.API_KEY)
                    weatherViewModel.getWeatherByCityNameAndCountryCode("London", "GB",WeatherAccessKey.API_KEY)
                    weatherViewModel.getWeatherByCityNameAndStateAndCountryCode("Seattle", "WA,", "US",WeatherAccessKey.API_KEY)
                    println(weatherViewModel.weatherByCityName.value)
                    println(weatherViewModel.weatherByCityNameAndCountryCode.value)
                    println(weatherViewModel.weatherByCityNameAndStateAndCountryCode.value)
                }*/
            }
        }
    }
}
