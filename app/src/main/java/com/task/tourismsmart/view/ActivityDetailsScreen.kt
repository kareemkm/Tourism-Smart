package com.task.tourismsmart.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.task.tourismsmart.viewModel.ActivityViewModel
import org.w3c.dom.Text

@Composable
fun ActivityDetailsScreen(backStackEntry: NavBackStackEntry , viewModel: ActivityViewModel = viewModel()){

    val activityName = backStackEntry.arguments?.getString("ActivityName") ?: return

    val activity by viewModel.getActivityByName(activityName).collectAsState(initial = null)

    activity?.let { activityDetails ->

        Column {
            Text(text = activityDetails.name)
            Text(text = activityDetails.city)
        }

    }

}