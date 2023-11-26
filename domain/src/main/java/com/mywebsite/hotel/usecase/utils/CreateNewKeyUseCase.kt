package com.mywebsite.hotel.usecase.utils

import java.util.UUID

class CreateNewKeyUseCase {
    operator fun invoke() = UUID.randomUUID().toString()
}