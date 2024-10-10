package com.ermias.openweatherapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ermias.openweatherapp.WeatherViewModel
import com.ermias.openweatherapp.weather.WeatherAccessKey
import com.ermias.openweatherapp.weather.WeatherMaps
import com.ermias.openweatherapp.weather.WeatherMapsItem

@Composable
fun WeatherAPIMainScreen(weatherViewModel: WeatherViewModel, city: String){
    var r by remember { mutableStateOf(WeatherMaps())}//(ArrayList<WeatherMapsItem>()) }
    val s = city.split("_")
    LaunchedEffect(Unit) {
        if(s[s.size-1].toInt() == 1) {
            weatherViewModel.getWeatherByCityName(s[0], WeatherAccessKey.API_KEY)
            r = weatherViewModel.weatherByCityName.value
        }else if(s[s.size-1].toInt() == 2) {
            weatherViewModel.getWeatherByCityNameAndCountryCode(s[0],s[1],WeatherAccessKey.API_KEY)
            r = weatherViewModel.weatherByCityNameAndCountryCode.value
        } else if(s[s.size-1].toInt() == 3) {
            weatherViewModel.getWeatherByCityNameAndCountryCode(s[0],s[1],WeatherAccessKey.API_KEY)
            r = weatherViewModel.weatherByCityNameAndCountryCode.value
        }

    }
    Column {
        Spacer(modifier = Modifier.height(40.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(1)) {
            items(r.size) { i ->
                Column {
                    Spacer(modifier = Modifier.height(40.dp))
                    Text(text = r[i].lat.toString() + "  " + r[i].lon + "  " + r[i].name)
                }
            }
        }
    }
}
