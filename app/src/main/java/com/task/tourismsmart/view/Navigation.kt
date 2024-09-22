package com.task.tourismsmart.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.task.tourismsmart.view.activity.ActivityDetailsScreen
import com.task.tourismsmart.view.activity.ActivityScreen
import com.task.tourismsmart.view.home_nav.IntroScreen
import com.task.tourismsmart.view.hotel.CityDetailsScreen
import com.task.tourismsmart.view.hotel.HotelDetailsScreen
import com.task.tourismsmart.view.hotel.HotelsScreen
import com.task.tourismsmart.view.restaurant.RestaurantDetailsScreen
import com.task.tourismsmart.view.restaurant.RestaurantScreen

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
        // City
        composable("CityDetails/{cityName}") { BackStackEntry ->
            CityDetailsScreen(backStackEntry = BackStackEntry )
        }

    }

}