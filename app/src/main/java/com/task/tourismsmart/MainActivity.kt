package com.task.tourismsmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.task.tourismsmart.ui.theme.TourismSmartTheme
import com.task.tourismsmart.view.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TourismSmartTheme {
                Navigation()
            }
        }
    }
}
