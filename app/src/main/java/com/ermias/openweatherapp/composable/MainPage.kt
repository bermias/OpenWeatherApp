package com.ermias.openweatherapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WeatherAPIMainScreen(navController: NavController){
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        Button(onClick = {
            navController.navigate("WeatherCityName")
        }) {
            Text(text = "Get Weather By City Name")
        }
        Button(onClick = {
            navController.navigate("WeatherCityNameAndCountryCode")
        }) {
            Text(text = "Get Weather By City Name And Country Code")
        }
        Button(onClick = {
            navController.navigate("WeatherCityNameAndStateAndCountryCode")
        }) {
            Text(text = "Get Weather By City Name And State And Country USA")
        }
    }
}
