package com.mywebsite.hotel.models.room

data class Room(
    val id: Int? = null,
    val name: String? = null,
    val price : Int? = null,
    val pricePer : String? = null,
    val peculiarities : List<String> = listOf(),
    val imageUrls  : List<String> = listOf()
)
