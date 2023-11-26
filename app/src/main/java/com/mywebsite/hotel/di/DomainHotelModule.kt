package com.mywebsite.hotel.di

import com.mywebsite.hotel.repository.HotelRepository
import com.mywebsite.hotel.usecase.booking.GetBookingInfoUseCase
import com.mywebsite.hotel.usecase.hotel.GetHotelInfoUseCase
import com.mywebsite.hotel.usecase.room.GetListOfRoomsUseCase
import com.mywebsite.hotel.usecase.tourist.AddTouristUseCase
import com.mywebsite.hotel.usecase.tourist.ObserveAllTouristsUseCase
import com.mywebsite.hotel.usecase.tourist.SaveListOfTouristsUseCase
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

    @Provides
    fun provideAddTouristUseCase(hotelRepository: HotelRepository): AddTouristUseCase {
        return AddTouristUseCase(hotelRepository = hotelRepository)
    }

    @Provides
    fun provideSaveListOfTouristsUseCase(hotelRepository: HotelRepository): SaveListOfTouristsUseCase {
        return SaveListOfTouristsUseCase(hotelRepository = hotelRepository)
    }

    @Provides
    fun provideObserveAllTouristsUseCase(hotelRepository: HotelRepository): ObserveAllTouristsUseCase {
        return ObserveAllTouristsUseCase(hotelRepository = hotelRepository)
    }
}