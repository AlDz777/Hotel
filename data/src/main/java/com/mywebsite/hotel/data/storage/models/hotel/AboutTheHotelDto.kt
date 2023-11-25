package com.mywebsite.hotel.data.storage.models.hotel

import com.google.gson.annotations.SerializedName

data class AboutTheHotelDto(
    @SerializedName("description") val description: String? = null,
    @SerializedName("peculiarities") val peculiarities: List<String>? = null
)
