package com.mywebsite.hotel.di

import com.mywebsite.hotel.data.storage.room.HotelRoomDatabase
import com.mywebsite.hotel.data.storage.room.dao.TouristDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {

    @Provides
    @Singleton
    fun provideTouristDao(hotelRoomDatabase: HotelRoomDatabase): TouristDao {
        return hotelRoomDatabase.touristDao()
    }
}