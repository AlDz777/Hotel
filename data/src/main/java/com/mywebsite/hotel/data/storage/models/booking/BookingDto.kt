package com.mywebsite.hotel.data.storage.models.booking

import com.google.gson.annotations.SerializedName

data class BookingDto(
    @SerializedName("id") val id : Int? = null,
    @SerializedName("hotel_name") val hotelName : String? = null,
    @SerializedName("hotel_adress") val hotelAdress: String? = null,
    @SerializedName("horating") val horating: Int? = null,
    @SerializedName("rating_name") val ratingName: String? = null,
    @SerializedName("departure") val departure: String? = null,
    @SerializedName("arrival_country") val arrivalCountry: String? = null,
    @SerializedName("tour_date_start") val tourDateStart: String? = null,
    @SerializedName("tour_date_stop") val tourDateStop: String? = null,
    @SerializedName("number_of_nights") val numberOfNights: Int? = null,
    @SerializedName("room") val room: String? = null,
    @SerializedName("nutrition") val nutrition: String? = null,
    @SerializedName("tour_price") val tourPrice: Int? = null,
    @SerializedName("fuel_charge") val fuelCharge: Int? = null,
    @SerializedName("service_charge") val serviceCharge: Int? = null
)
