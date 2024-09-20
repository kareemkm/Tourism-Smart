package com.task.tourismsmart.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun IntroScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                navController.navigate("HotelsScreen")
            }
        ) {
            Text(text = "Hotels")
        }
        Button(
            onClick = {
                navController.navigate("RestaurantScreen")
            }
        ) {
            Text(text = "restaurant_cafe")
        }
        Button(
            onClick = {
                navController.navigate("ActivityScreen")
            }
        ) {
            Text(text = "Activity")
        }


    }
}