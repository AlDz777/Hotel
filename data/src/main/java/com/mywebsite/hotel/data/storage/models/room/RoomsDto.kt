package com.mywebsite.hotel.data.storage.models.room

import com.google.gson.annotations.SerializedName

data class RoomsDto(
    @SerializedName("rooms") val roomsDto : List<RoomDto> = listOf()
)
