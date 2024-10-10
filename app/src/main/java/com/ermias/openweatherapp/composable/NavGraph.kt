package com.ermias.openweatherapp.composable

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ermias.openweatherapp.WeatherViewModel

@Composable
fun WeatherNav(weathrViewModel: WeatherViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "Main") {
        composable("Main") {
            WeatherAPIMainScreen(navController)
        }
        composable("WeatherCityName") {
            WeatherCityNameScreen(navController)
        }
        composable("WeatherCityNameAndCountryCode") {
            WeatherCityNameScreenAndCountryCode(navController)
        }
        composable("WeatherCityNameAndStateAndCountryCode") {
            WeatherCityNameAndStateAndCountryCodeScreen(navController)
        }
        composable("Detail/{city}",
            arguments = listOf(navArgument("city")
            { type = NavType.StringType }),) {backStackEntry ->
            val city = requireNotNull(backStackEntry.arguments?.getString("city"))
            WeatherAPIMainScreen(weathrViewModel, city)
        }

    }
}