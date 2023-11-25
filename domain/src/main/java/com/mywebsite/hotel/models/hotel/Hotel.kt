package com.mywebsite.hotel.models.hotel

data class Hotel(
    val id: Int? = null,
    val name: String? = null,
    val adress: String? = null,
    val minimalPrice: Int? = null,
    val priceForIt: String? = null,
    val rating: Int? = null,
    val ratingName: String? = null,
    val imageUrls: List<String> = listOf(),
    val aboutTheHotel: AboutTheHotel? = null
)
