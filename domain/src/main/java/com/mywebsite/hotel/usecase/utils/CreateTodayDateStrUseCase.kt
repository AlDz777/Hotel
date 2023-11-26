package com.mywebsite.hotel.usecase.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CreateTodayDateStrUseCase() {

    operator fun invoke(): String {
        val currentLocalDate: LocalDate = LocalDate.now()
        val formatterToDateStr: DateTimeFormatter = DateTimeFormatter.BASIC_ISO_DATE
        return currentLocalDate.format(formatterToDateStr)
    }
}