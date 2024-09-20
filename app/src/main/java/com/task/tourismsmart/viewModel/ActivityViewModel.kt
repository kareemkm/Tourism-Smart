package com.task.tourismsmart.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.tourismsmart.api.RetrofitInstance
import com.task.tourismsmart.doman.Activity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ActivityViewModel: ViewModel() {

    private val _activityList = MutableStateFlow<List<Activity>>(emptyList())
    val activityList : MutableStateFlow<List<Activity>> get() = _activityList

    init {
        fetchActivity()
    }

    private fun fetchActivity(){
        viewModelScope.launch {
            val activity = RetrofitInstance.api.getActivity()
            _activityList.value = activity
        }
    }
}