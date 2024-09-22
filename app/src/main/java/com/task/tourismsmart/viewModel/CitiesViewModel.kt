package com.task.tourismsmart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.tourismsmart.api.RetrofitInstance
import com.task.tourismsmart.doman.Cities
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class CitiesViewModel: ViewModel() {

    private val _citiesList = MutableStateFlow<List<Cities>>(emptyList())
    val citiesList : StateFlow<List<Cities>> get() = _citiesList

    init {
        fetchCities()
    }

    private fun fetchCities(){
        viewModelScope.launch {
            val cities = RetrofitInstance.api.getCities()
            _citiesList.value = cities.cities2
        }

    }
    fun getCityByName(name:String) = flow {
        val city = _citiesList.value.find { it.name == name }
        emit(city)
    }
}