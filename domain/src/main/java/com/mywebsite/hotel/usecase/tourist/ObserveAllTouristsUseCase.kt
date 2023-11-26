package com.mywebsite.hotel.usecase.tourist

import com.mywebsite.hotel.repository.HotelRepository

class ObserveAllTouristsUseCase(private val hotelRepository: HotelRepository) {

    operator fun invoke() = hotelRepository.observeAllTourists()
}