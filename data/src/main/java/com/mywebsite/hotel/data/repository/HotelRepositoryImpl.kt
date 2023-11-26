package com.mywebsite.hotel.data.repository

import com.mywebsite.hotel.data.storage.helpers.DatabaseMapper
import com.mywebsite.hotel.data.storage.helpers.DatabaseMapper.mapRoomDtoListToModel
import com.mywebsite.hotel.data.storage.helpers.StorageHelper.createFailureLog
import com.mywebsite.hotel.data.storage.helpers.mapModelToEntity
import com.mywebsite.hotel.data.storage.helpers.mapTouristModelListToEntity
import com.mywebsite.hotel.data.storage.models.booking.BookingDto
import com.mywebsite.hotel.data.storage.models.room.RoomDto
import com.mywebsite.hotel.data.storage.network.ApiService
import com.mywebsite.hotel.data.storage.models.hotel.HotelDto
import com.mywebsite.hotel.data.storage.room.dao.TouristDao
import com.mywebsite.hotel.data.storage.room.entities.asDomainModel
import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.repository.HotelRepository
import com.mywebsite.hotel.models.booking.Booking
import com.mywebsite.hotel.models.tourist.Tourist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map

class HotelRepositoryImpl(
    private val apiService: ApiService,
    private val touristDao: TouristDao
): HotelRepository {

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

    override fun addTourist(tourist: Tourist) {
        try {
            val touristEntity = mapModelToEntity(tourist)
            touristDao.insert(touristEntity)
        } catch (e: Exception) {
            createFailureLog("addTourist", e.message)
        }
    }

    override fun saveListOfTourists(listOfTourists: List<Tourist>) {
        try {
            val touristEntityList = mapTouristModelListToEntity(listOfTourists)
            touristDao.insertAll(touristEntityList)
        } catch (e: Exception) {
            createFailureLog("saveListOfTourists", e.message)
        }
    }

    override fun observeAllTourists(): Flow<List<Tourist>> {
        return try {
            touristDao.observeAllTourists().map {
                it.asDomainModel()
            }
        } catch (e: Exception) {
            createFailureLog("getListOfTourists", e.message)
            emptyFlow()
        }
    }
}