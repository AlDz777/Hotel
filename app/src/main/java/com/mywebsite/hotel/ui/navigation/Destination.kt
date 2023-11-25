package com.mywebsite.hotel.ui.navigation

interface Destination {
    val route: String
    val title: String
}

object BaseMainDestination: Destination {
    override val route = "main"
    override val title = "main"
}

object HotelDestination: Destination {
    override val route = "hotel"
    override val title = "hotel"
}

object RoomDestination: Destination {
    override val route = "room"
    override val title = "room"
}

object BookingDestination: Destination {
    override val route = "booking"
    override val title = "booking"
}

object PaidDestination: Destination {
    override val route = "paid"
    override val title = "paid"
}
