package com.mywebsite.hotel.usecase.hotel

import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.repository.HotelRepository

class GetHotelInfoUseCase(private val hotelRepository: HotelRepository) {
    suspend operator fun invoke(): Hotel? = hotelRepository.getHotelInfo()
}