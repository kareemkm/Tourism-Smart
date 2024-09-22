package com.task.tourismsmart.view.hotel

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.task.tourismsmart.viewModel.HotelViewModel

@Composable
fun HotelDetailsScreen(backStackEntry: NavBackStackEntry , viewModel: HotelViewModel = viewModel()){

    val hotelName = backStackEntry.arguments?.getString("hotelName") ?: return

    val hotel by viewModel.getHotelByName(hotelName).collectAsState(initial = null)

    hotel?.let {hotelDetails ->

        Column {
            Text(text = hotelDetails.name)
            Text(text = hotelDetails.city)
            Text(text = hotelDetails.totalScore)
            Text(text = hotelDetails.urlGoogleMap)
        }


    }?: run {
        Text(text = "Loading...")
    }

}