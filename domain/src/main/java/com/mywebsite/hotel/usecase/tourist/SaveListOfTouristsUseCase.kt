package com.mywebsite.hotel.usecase.tourist

import com.mywebsite.hotel.models.tourist.SaveListOfTouristsParams
import com.mywebsite.hotel.repository.HotelRepository

class SaveListOfTouristsUseCase(private val hotelRepository: HotelRepository) {

    operator fun invoke(params: SaveListOfTouristsParams) {
        hotelRepository.saveListOfTourists(params.listOfTourists)
    }
}