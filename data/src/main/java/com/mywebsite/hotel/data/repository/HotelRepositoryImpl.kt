package com.mywebsite.hotel.data.repository

import com.mywebsite.hotel.data.storage.helpers.DatabaseMapper
import com.mywebsite.hotel.data.storage.helpers.DatabaseMapper.mapRoomDtoListToModel
import com.mywebsite.hotel.data.storage.models.booking.BookingDto
import com.mywebsite.hotel.data.storage.models.room.RoomDto
import com.mywebsite.hotel.data.storage.network.ApiService
import com.mywebsite.hotel.data.storage.models.hotel.HotelDto
import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.repository.HotelRepository
import com.mywebsite.hotel.models.booking.Booking

class HotelRepositoryImpl(private val apiService: ApiService): HotelRepository {

// 1. Variables_____________________________________________________________________________________

// 2. Utils_________________________________________________________________________________________

// 3. Setters_______________________________________________________________________________________

// 4. Getters_______________________________________________________________________________________

    override suspend fun getHotelInfo(): Hotel? {
        val hotelInfo: HotelDto? = try {
            apiService.getHotelInfo()
        } catch (e: Exception) {
            null
        }
        return hotelInfo?.let { DatabaseMapper.mapDtoToModel(it) }
    }

    override suspend fun getListOfRooms(): List<Room> {
        val listOfRooms: List<RoomDto> = try {
            apiService.getHotelRooms().roomsDto
        } catch (e: Exception) {
            emptyList()
        }
        return mapRoomDtoListToModel(listOfRooms)
    }

    override suspend fun getBooking(): Booking? {
        val bookingInfo: BookingDto? = try {
            apiService.getBooking()
        } catch (e: Exception) {
            null
        }
        return bookingInfo?.let { DatabaseMapper.mapDtoToModel(it) }
    }
}