package com.mywebsite.hotel.usecase.booking

import com.mywebsite.hotel.repository.HotelRepository

class GetBookingInfoUseCase(private val hotelRepository: HotelRepository) {
    suspend operator fun invoke() = hotelRepository.getBooking()
}