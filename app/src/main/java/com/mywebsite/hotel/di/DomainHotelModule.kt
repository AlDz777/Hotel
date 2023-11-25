package com.mywebsite.hotel.di

import com.mywebsite.hotel.repository.HotelRepository
import com.mywebsite.hotel.usecase.booking.GetBookingInfoUseCase
import com.mywebsite.hotel.usecase.hotel.GetHotelInfoUseCase
import com.mywebsite.hotel.usecase.room.GetListOfRoomsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainHotelModule {

    @Provides
    fun provideGetHotelInfoUseCase(hotelRepository: HotelRepository): GetHotelInfoUseCase {
        return GetHotelInfoUseCase(hotelRepository = hotelRepository)
    }

    @Provides
    fun provideGetListOfRoomsUseCase(hotelRepository: HotelRepository): GetListOfRoomsUseCase {
        return GetListOfRoomsUseCase(hotelRepository = hotelRepository)
    }

    @Provides
    fun provideGetBookingInfoUseCase(hotelRepository: HotelRepository): GetBookingInfoUseCase {
        return GetBookingInfoUseCase(hotelRepository = hotelRepository)
    }
}