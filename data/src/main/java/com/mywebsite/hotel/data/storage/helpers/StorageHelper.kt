package com.mywebsite.hotel.data.storage.helpers

import android.util.Log

object StorageHelper {

    const val ROOM_DATABASE_NAME = "roomDatabase"
    const val TABLE_TOURISTS = "tourists"

    fun createFailureLog(functionName: String, errorMessage: String?) {
        Log.e("StorageLog", "$functionName failure: $errorMessage")
    }

}