package com.mywebsite.hotel.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mywebsite.hotel.MainViewModel
import com.mywebsite.hotel.ui.screens.BookingScreen
import com.mywebsite.hotel.ui.screens.HotelScreen
import com.mywebsite.hotel.ui.screens.PaidScreen
import com.mywebsite.hotel.ui.screens.RoomScreen

fun NavGraphBuilder.hotelGraph(navController: NavController, viewModel: MainViewModel) {
    navigation(startDestination = HotelDestination.route, route = BaseMainDestination.route) {
        composable(HotelDestination.route) {
            HotelScreen(onNavigateToRoomScreen = { navController.navigate(RoomDestination.route) }, viewModel = viewModel)
        }

        composable(RoomDestination.route) {
            RoomScreen(onNavigateToHotelScreen = { navController.navigateUp() }, onNavigateToBookingScreen = { navController.navigate(BookingDestination.route) }, viewModel = viewModel)
        }

        composable(BookingDestination.route) {
            BookingScreen(onNavigateToRoomScreen = { navController.navigateUp() }, onNavigateToPaidScreen = { navController.navigate(PaidDestination.route) }, viewModel = viewModel)
        }

        composable(PaidDestination.route) {
            PaidScreen( onNavigateToBookingScreen = { navController.navigateUp() }, onNavigateToBaseScreen = { navController.navigate(BaseMainDestination.route) } )
        }
    }
}