package com.task.tourismsmart.view.home_nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.task.tourismsmart.R
import com.task.tourismsmart.view.componants.CardCities
import com.task.tourismsmart.view.componants.Cards
import com.task.tourismsmart.viewModel.CitiesViewModel

@Composable
fun IntroScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        HeaderSection()
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            item { Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "City",fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Blue)
                Text(text = "Sea all", fontSize = 12.sp, fontWeight = FontWeight.Bold)
            } }
            item { CitySection(navController = navController) }
            item { Text(
                text = "Where is your next destination",
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                color = Color.Blue,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp).fillMaxWidth()
            ) }
            item {
                Cards(
                    title = "Hotels",
                    imageResId = R.drawable.hotel ,
                    onClickCard = {navController.navigate("HotelsScreen")}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Cards(
                    title = "Restaurant",
                    imageResId = R.drawable.restaurant ,
                    onClickCard = {navController.navigate("RestaurantScreen")}
                )
                Spacer(modifier = Modifier.height(16.dp))
                Cards(
                    title = "Activity",
                    imageResId = R.drawable.activity ,
                    onClickCard = {navController.navigate("ActivityScreen")}
                )
            }
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }


    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.er),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hello, Kareem",
                style = MaterialTheme.typography.headlineSmall
            )
        }
        IconButton(
            onClick = {}
        ) {
            Icon(
                Icons.Default.Notifications,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun CitySection(viewModel: CitiesViewModel = viewModel() , navController: NavController?) {

    val citiesList by viewModel.citiesList.collectAsState()

    LazyRow(
        modifier = Modifier.fillMaxWidth().height(150.dp)
    ) {
        items(citiesList){city ->
            CardCities(
                image = city.image,
                title = city.name,
                onClickCard = {navController?.navigate("CityDetails/${city.name}")}
            )
        }
    }
}
