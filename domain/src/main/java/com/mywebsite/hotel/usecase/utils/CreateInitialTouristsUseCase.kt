package com.mywebsite.hotel.usecase.utils

import com.mywebsite.hotel.models.tourist.Tourist

class CreateInitialTouristsUseCase {
    operator fun invoke(): List<Tourist> {
        val tourist1 = Tourist(
            firstName = "Иван",
            lastName = "Иванов",
            dayOfBirth = "25.05.1992",
            citizenship = "Russia",
            passportNum = "2145 587885",
            passportValidation = "01.02.2030"
        )
        val tourist2 = Tourist(
            firstName = "Алексей",
            lastName = "Алексеев",
            dayOfBirth = "23.07.1990",
            citizenship = "Russia",
            passportNum = "6589 964735",
            passportValidation = "03.06.2024"
        )
        return listOf(tourist1, tourist2)
    }
}