package com.task.tourismsmart.view.activity

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.task.tourismsmart.doman.Activity
import com.task.tourismsmart.viewModel.ActivityViewModel

@Composable
fun ActivityScreen(viewModel: ActivityViewModel = viewModel() , navController: NavController){

    val activityList by viewModel.activityList.collectAsState()
    var query by remember { mutableStateOf("") }




    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        TextField(
            value = query,
            onValueChange = {query = it},
            label = { Text(text = "Search by name Activity") }
        )
        val filterActivity = if (query.isEmpty()){
            activityList
        } else{
            activityList.filter {
                it.name.contains(query , ignoreCase = true)
            }
        }
        Text(text = "Hotels")
        LazyColumn {
            items(filterActivity){activity ->
                HotelItem(
                    activity = activity,
                    navController = navController
                )
            }
        }

    }
}
@Composable
private fun HotelItem(activity: Activity , navController: NavController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("ActivityDetails/${activity.name}")
            }
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ){
            AsyncImage(
                model = activity.image,
                contentDescription = activity.image,
                modifier = Modifier.size(100.dp).padding(end = 8.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = activity.name
                )
                Text(
                    text = activity.city
                )
            }
        }
    }

}