package com.mywebsite.hotel.data.storage.network

import com.mywebsite.hotel.data.storage.models.booking.BookingDto
import com.mywebsite.hotel.data.storage.models.room.RoomDto
import com.mywebsite.hotel.data.storage.models.hotel.HotelDto
import com.mywebsite.hotel.data.storage.models.room.RoomsDto
import retrofit2.http.GET

interface ApiService {
    @GET("v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo(): HotelDto?

    @GET("v3/8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getHotelRooms(): RoomsDto

    @GET("v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBooking(): BookingDto?
}