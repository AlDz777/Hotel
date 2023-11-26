package com.mywebsite.hotel.usecase.tourist

import com.mywebsite.hotel.models.tourist.AddTouristParams
import com.mywebsite.hotel.repository.HotelRepository

class AddTouristUseCase(private val hotelRepository: HotelRepository) {
    operator fun invoke(params: AddTouristParams) {
        hotelRepository.addTourist(params.tourist)
    }
}