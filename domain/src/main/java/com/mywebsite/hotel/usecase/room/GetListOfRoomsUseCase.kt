package com.mywebsite.hotel.usecase.room

import com.mywebsite.hotel.repository.HotelRepository

class GetListOfRoomsUseCase(private val hotelRepository: HotelRepository) {
    suspend operator fun invoke() = hotelRepository.getListOfRooms()
}