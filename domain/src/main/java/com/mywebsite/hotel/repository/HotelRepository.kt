package com.mywebsite.hotel.repository

import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.models.booking.Booking

interface HotelRepository {

    suspend fun getHotelInfo(): Hotel?

    suspend fun getListOfRooms(): List<Room>

    suspend fun getBooking(): Booking?
}