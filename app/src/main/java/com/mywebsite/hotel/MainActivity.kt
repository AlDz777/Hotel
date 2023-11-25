package com.mywebsite.hotel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mywebsite.hotel.ui.navigation.BaseMainDestination
import com.mywebsite.hotel.ui.navigation.hotelGraph
import com.mywebsite.hotel.ui.theme.HotelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

// 1. Variables_____________________________________________________________________________________

    private val viewModel: MainViewModel by viewModels()

// 2. Overrides_____________________________________________________________________________________

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HotelTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController,
                        startDestination = BaseMainDestination.route,
                        Modifier
                            .background(Color.Gray.copy(alpha = 0.15f))
                            .verticalScroll(rememberScrollState())
                    ) {
                        hotelGraph(navController, viewModel)
                    }
                }
            }
        }
    }

// 3. Utils_________________________________________________________________________________________

// 4. ViewModelInteraction__________________________________________________________________________

}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HotelTheme {
//        Greeting("Android")
//    }
//}