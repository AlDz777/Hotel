package com.mywebsite.hotel.data.storage.models.room

import com.google.gson.annotations.SerializedName

data class RoomDto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("price") val price : Int? = null,
    @SerializedName("price_per") val pricePer : String? = null,
    @SerializedName("peculiarities") val peculiarities : List<String> = listOf(),
    @SerializedName("image_urls") val imageUrls  : List<String> = listOf()
)
