package com.mywebsite.hotel.repository

import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.models.booking.Booking
import com.mywebsite.hotel.models.tourist.Tourist
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    suspend fun getHotelInfo(): Hotel?

    suspend fun getListOfRooms(): List<Room>

    suspend fun getBooking(): Booking?

    fun addTourist(tourist: Tourist)

    fun saveListOfTourists(listOfTourists: List<Tourist>)

    fun observeAllTourists(): Flow<List<Tourist>>
}