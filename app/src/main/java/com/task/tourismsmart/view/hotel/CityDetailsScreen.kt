package com.task.tourismsmart.view.hotel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import coil.compose.AsyncImage
import com.task.tourismsmart.viewModel.CitiesViewModel

@Composable
fun CityDetailsScreen(backStackEntry: NavBackStackEntry,viewModel: CitiesViewModel = viewModel()){

    val cityName = backStackEntry.arguments?.getString("cityName") ?: return

    val city by viewModel.getCityByName(cityName).collectAsState(initial = null)

    city?.let { cityDetails ->
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = cityDetails.name,
                fontSize = 40.sp,
                color = Color.Blue, textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(1.dp)
            )
            AsyncImage(
                model = cityDetails.image,
                contentDescription = "",
                modifier = Modifier.fillMaxWidth().height(400.dp)
            )
            Text(
                text = cityDetails.description,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}