package com.mywebsite.hotel.di

import android.content.Context
import androidx.room.Room
import com.mywebsite.hotel.data.storage.helpers.StorageHelper.ROOM_DATABASE_NAME
import com.mywebsite.hotel.data.storage.room.HotelRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext appContext: Context): HotelRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            HotelRoomDatabase::class.java,
            ROOM_DATABASE_NAME
        ).build()
    }
}