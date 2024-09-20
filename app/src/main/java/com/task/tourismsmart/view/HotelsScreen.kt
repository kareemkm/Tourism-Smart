package com.task.tourismsmart.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.task.tourismsmart.doman.Hotel
import com.task.tourismsmart.viewModel.HotelViewModel

@Composable
fun HotelsScreen(viewModel: HotelViewModel = viewModel()){

    val hotelList by viewModel.hotelList.collectAsState()

    var query by remember { mutableStateOf("") }




    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = {query = it},
            label = { Text(text = "Search by name hotel") }
        )
        val filterHotels = if (query.isEmpty()){
            hotelList
        } else{
            hotelList.filter {
                it.city.contains(query , ignoreCase = true)
            }
        }
        Text(text = "Hotels")
        LazyColumn {
            items(filterHotels){hotel ->
                HotelItem(hotel)
            }
        }

    }
}
@Composable
private fun HotelItem(hotel: Hotel){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ){
            AsyncImage(
                model = hotel.image1,
                contentDescription = hotel.image1,
                modifier = Modifier.size(100.dp).padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )
            AsyncImage(
                model = hotel.image2,
                contentDescription = hotel.image2,
                modifier = Modifier.size(100.dp).padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = hotel.name
                )
                Text(
                    text = hotel.city
                )
            }
        }
    }
}















