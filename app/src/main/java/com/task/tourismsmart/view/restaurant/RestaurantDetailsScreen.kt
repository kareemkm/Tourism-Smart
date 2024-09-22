package com.task.tourismsmart.view.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.task.tourismsmart.viewModel.RestaurantViewModel

@Composable
fun RestaurantDetailsScreen(backStackEntry: NavBackStackEntry , viewModel: RestaurantViewModel = viewModel()){

    val restaurantName = backStackEntry.arguments?.getString("RestaurantName") ?: return

    val restaurant by viewModel.getRestaurantByName(restaurantName).collectAsState(initial = null)

    restaurant?.let { restaurantDetails ->

        Column {
            Text(text = restaurantDetails.name)
            Text(text = restaurantDetails.rating)
        }

    }?: run {
        Text(text = "Loding...")
    }
}