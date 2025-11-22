package com.muhammad.skyflow.presentation.navigaton

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.muhammad.skyflow.presentation.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navHostController = rememberNavController()
    NavHost(navController = navHostController, startDestination = Destination.HomeScreen){
        composable<Destination.HomeScreen>{
            HomeScreen()
        }
    }
}