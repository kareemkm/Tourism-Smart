package com.task.tourismsmart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.tourismsmart.api.RetrofitInstance
import com.task.tourismsmart.doman.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel:ViewModel() {


    private val _restaurantList = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurantList : StateFlow<List<Restaurant>> get() = _restaurantList

    init {
        fetchRestaurant()
    }

    private fun fetchRestaurant(){
        viewModelScope.launch {
            val restaurant = RetrofitInstance.api.getRestaurant()
            _restaurantList.value = restaurant
        }
    }
}