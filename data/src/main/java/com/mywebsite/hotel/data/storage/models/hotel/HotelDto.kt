package com.mywebsite.hotel.data.storage.models.hotel

import com.google.gson.annotations.SerializedName

data class HotelDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("adress") val adress: String? = null,
    @SerializedName("minimal_price") val minimalPrice: Int? = null,
    @SerializedName("price_for_it") val priceForIt: String? = null,
    @SerializedName("rating") val rating: Int? = null,
    @SerializedName("rating_name") val ratingName: String? = null,
    @SerializedName("image_urls") val imageUrls: List<String> = listOf(),
    @SerializedName("about_the_hotel") val aboutTheHotel: AboutTheHotelDto? = null
)
