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
        // Intro
        composable("IntroScreen"){
            IntroScreen(navController = navController)
        }
        // Hotel
        composable("HotelsScreen") {
            HotelsScreen(navController = navController)
        }
        composable("HotelDetails/{hotelName}") { backStackEntry ->
            HotelDetailsScreen(backStackEntry = backStackEntry)
        }
        // Restaurant
        composable("RestaurantScreen"){
            RestaurantScreen(navController = navController)
        }
        composable("RestaurantDetails/{RestaurantName}"){backStackEntry ->
            RestaurantDetailsScreen(backStackEntry = backStackEntry)
        }
        // Activity
        composable("ActivityScreen"){
            ActivityScreen(navController = navController)
        }
        composable("ActivityDetails/{ActivityName}"){backStackEntry ->
            ActivityDetailsScreen(backStackEntry = backStackEntry)
        }

    }

}