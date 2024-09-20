package com.task.tourismsmart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.tourismsmart.api.RetrofitInstance
import com.task.tourismsmart.doman.Hotel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class HotelViewModel:ViewModel() {

    private val _hotelList = MutableStateFlow<List<Hotel>>(emptyList())
    val hotelList : StateFlow<List<Hotel>> get() = _hotelList

    init {
        fetchHotels()
    }

    private fun fetchHotels(){
        viewModelScope.launch {
            val hotels = RetrofitInstance.api.getHotels()
            _hotelList.value = hotels
        }
    }

    fun getHotelByName(name:String) = flow {
        val hotel = _hotelList.value.find { it.name == name }
        emit(hotel)
    }
}