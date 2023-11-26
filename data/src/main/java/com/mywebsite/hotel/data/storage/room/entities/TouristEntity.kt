package com.mywebsite.hotel.data.storage.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mywebsite.hotel.data.storage.helpers.StorageHelper.TABLE_TOURISTS
import com.mywebsite.hotel.models.tourist.Tourist

@Entity(tableName = TABLE_TOURISTS)
data class TouristEntity(
    @PrimaryKey @ColumnInfo(name = "key") val key: String,
    @ColumnInfo(name = "created_date") val createdDate: String,
    @ColumnInfo(name = "first_name") var firstName: String = "",
    @ColumnInfo(name = "last_name") var lastName: String = "",
    @ColumnInfo(name = "day_of_birth") var dayOfBirth: String = "",
    @ColumnInfo(name = "citizenship") var citizenship: String = "",
    @ColumnInfo(name = "passport_num") var passportNum: String = "",
    @ColumnInfo(name = "passport_validation") var passportValidation: String = ""
)

fun List<TouristEntity>.asDomainModel(): List<Tourist> {
    return map {
        it.asDomainModel()
    }
}

fun TouristEntity.asDomainModel(): Tourist {
    return Tourist(
        key = this.key,
        createdDate = this.createdDate,
        firstName = this.firstName,
        lastName = this.lastName,
        dayOfBirth = this.dayOfBirth,
        citizenship = this.citizenship,
        passportNum = this.passportNum,
        passportValidation = this.passportValidation
    )
}
