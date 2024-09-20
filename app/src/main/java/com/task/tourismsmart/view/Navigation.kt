package com.task.tourismsmart.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "IntroScreen"
    ){
        composable("IntroScreen"){
            IntroScreen(navController = navController)
        }
        composable("HotelsScreen") {
            HotelsScreen()
        }
        composable("RestaurantScreen"){
            RestaurantScreen()
        }
        composable("ActivityScreen"){
            ActivityScreen()
        }

    }

}