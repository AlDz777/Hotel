package com.mywebsite.hotel.models.booking

data class Booking(
    val id: Int? = null,
    val hotelName: String? = null,
    val hotelAdress: String? = null,
    val horating: Int? = null,
    val ratingName: String? = null,
    val departure: String? = null,
    val arrivalCountry: String? = null,
    val tourDateStart: String? = null,
    val tourDateStop: String? = null,
    val numberOfNights: Int? = null,
    val room: String? = null,
    val nutrition: String? = null,
    val tourPrice: Int? = null,
    val fuelCharge: Int? = null,
    val serviceCharge: Int? = null
)
