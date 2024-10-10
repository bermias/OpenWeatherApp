package com.ermias.openweatherapp.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun WeatherCityNameScreen(navController: NavController) {
    val textState = remember { mutableStateOf("") }
    Column {
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            label = { Text("Enter City Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val city = textState.value +"_1"
            navController.navigate("Detail/${city}")
        }){
            Text(text = "Get Weather")
        }
    }
}

@Composable
fun WeatherCityNameScreenAndCountryCode(navController: NavController) {
    val textState1 = remember { mutableStateOf("") }
    val textState2 = remember { mutableStateOf("") }
    Column {
        TextField(
            value = textState1.value,
            onValueChange = { textState1.value = it },
            label = { Text("Enter City Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = textState2.value,
            onValueChange = { textState2.value = it },
            label = { Text("Country Code") },
            modifier = Modifier.fillMaxWidth()
        )

        val cityAndCountryCode = textState1.value + "," + textState2.value +"_2"
        Button(onClick = {
            navController.navigate("Detail/${cityAndCountryCode}")
        }){
            Text(text = "Get Weather")
        }
    }
}

@Composable
fun WeatherCityNameAndStateAndCountryCodeScreen(navController: NavController) {
    val textState1 = remember { mutableStateOf("") }
    val textState2 = remember { mutableStateOf("") }
    val textState3 = remember { mutableStateOf("") }
    Column {
        TextField(
            value = textState1.value,
            onValueChange = { textState1.value = it },
            label = { Text("Enter City Name") },
            modifier = Modifier.fillMaxWidth()
        )
       /* TextField(
            value = textState2.value,
            onValueChange = { textState2.value = it },
            label = { Text("Country Code Only USA") },
            modifier = Modifier.fillMaxWidth()
        )*/
        TextField(
            value = textState3.value,
            onValueChange = { textState3.value = it },
            label = { Text("State Code") },
            modifier = Modifier.fillMaxWidth()
        )
        val cityAndCountryCodeAndState = textState1.value + ",_"  + textState3.value +"_3"
        Button(onClick = {
            navController.navigate("Detail/${cityAndCountryCodeAndState}")
        }){
            Text(text = "Get Weather")
        }
    }
}