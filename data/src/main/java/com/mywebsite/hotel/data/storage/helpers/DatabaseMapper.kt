package com.mywebsite.hotel.data.storage.helpers

import com.mywebsite.hotel.data.storage.models.booking.BookingDto
import com.mywebsite.hotel.data.storage.models.room.RoomDto
import com.mywebsite.hotel.data.storage.models.hotel.AboutTheHotelDto
import com.mywebsite.hotel.data.storage.models.hotel.HotelDto
import com.mywebsite.hotel.data.storage.room.entities.TouristEntity
import com.mywebsite.hotel.models.hotel.AboutTheHotel
import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.models.booking.Booking
import com.mywebsite.hotel.models.tourist.Tourist

object DatabaseMapper {

//HotelInfo_________________________________________________________________________________________

    fun mapDtoToModel(hotelDto: HotelDto): Hotel {
        val mAboutTheHotel = hotelDto.aboutTheHotel?.let { mapDtoToModel(it) }
        return Hotel(
            id = hotelDto.id,
            name = hotelDto.name,
            adress = hotelDto.adress,
            minimalPrice = hotelDto.minimalPrice,
            priceForIt = hotelDto.priceForIt,
            rating = hotelDto.rating,
            ratingName = hotelDto.ratingName,
            imageUrls = hotelDto.imageUrls,
            aboutTheHotel = mAboutTheHotel
        )
    }

    private fun mapDtoToModel(aboutTheHotel: AboutTheHotelDto): AboutTheHotel {
        return AboutTheHotel(
            description = aboutTheHotel.description,
            peculiarities = aboutTheHotel.peculiarities
        )
    }

//RoomInfo__________________________________________________________________________________________

    fun mapRoomDtoListToModel(listOfRooms: List<RoomDto>): List<Room> {
        return listOfRooms.map { mapRoomDtoToModel(it) }
    }

    fun mapRoomDtoToModel(roomDto: RoomDto): Room {
        return Room(
            id = roomDto.id,
            name = roomDto.name,
            price = roomDto.price,
            pricePer = roomDto.pricePer,
            peculiarities = roomDto.peculiarities,
            imageUrls = roomDto.imageUrls
        )
    }

//BookingInfo_______________________________________________________________________________________

    fun mapDtoToModel(bookingDto: BookingDto): Booking {
        return Booking(
            id = bookingDto.id,
            hotelName = bookingDto.hotelName,
            hotelAdress = bookingDto.hotelAdress,
            horating = bookingDto.horating,
            ratingName = bookingDto.ratingName,
            departure = bookingDto.departure,
            arrivalCountry = bookingDto.arrivalCountry,
            tourDateStart = bookingDto.tourDateStart,
            tourDateStop = bookingDto.tourDateStop,
            numberOfNights = bookingDto.numberOfNights,
            room = bookingDto.room,
            nutrition = bookingDto.nutrition,
            tourPrice = bookingDto.tourPrice,
            fuelCharge = bookingDto.fuelCharge,
            serviceCharge = bookingDto.serviceCharge,
        )
    }
}

//TouristInfo_______________________________________________________________________________________

    fun mapTouristModelListToEntity(touristList: List<Tourist>): List<TouristEntity> {
        return touristList.map { mapModelToEntity(it) }
    }

    fun mapModelToEntity(touristModel: Tourist): TouristEntity {
        return TouristEntity(
            key = touristModel.key,
            createdDate = touristModel.createdDate,
            firstName = touristModel.firstName,
            lastName = touristModel.lastName,
            dayOfBirth = touristModel.dayOfBirth,
            citizenship = touristModel.citizenship,
            passportNum = touristModel.passportNum,
            passportValidation = touristModel.passportValidation
        )
    }