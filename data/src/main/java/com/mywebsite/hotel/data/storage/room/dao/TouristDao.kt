package com.mywebsite.hotel.data.storage.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mywebsite.hotel.data.storage.helpers.StorageHelper.TABLE_TOURISTS
import com.mywebsite.hotel.data.storage.room.entities.TouristEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TouristDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(touristEntity: TouristEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(touristEntityList: List<TouristEntity>)

    @Query("SELECT * FROM $TABLE_TOURISTS ORDER BY created_date ")
    fun observeAllTourists(): Flow<List<TouristEntity>>
}