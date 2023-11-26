package com.mywebsite.hotel.models.tourist

import com.mywebsite.hotel.usecase.utils.CreateNewKeyUseCase
import com.mywebsite.hotel.usecase.utils.CreateTodayDateStrUseCase

data class Tourist(
    val key: String = CreateNewKeyUseCase().invoke(),
    val createdDate: String = CreateTodayDateStrUseCase().invoke(),
    var firstName: String = "",
    var lastName: String = "",
    var dayOfBirth: String = "",
    var citizenship: String = "",
    var passportNum: String = "",
    var passportValidation: String = ""
)