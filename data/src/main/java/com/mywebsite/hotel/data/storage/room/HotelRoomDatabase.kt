package com.mywebsite.hotel.data.storage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mywebsite.hotel.data.storage.room.dao.TouristDao
import com.mywebsite.hotel.data.storage.room.entities.TouristEntity

@Database(entities = [TouristEntity::class], version = 1, exportSchema = false)
abstract class HotelRoomDatabase : RoomDatabase() {
    abstract fun touristDao(): TouristDao
}