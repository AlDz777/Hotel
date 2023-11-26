package com.mywebsite.hotel

import android.util.Patterns
import androidx.compose.ui.focus.FocusRequester
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mywebsite.hotel.models.booking.Booking
import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.models.tourist.AddTouristParams
import com.mywebsite.hotel.models.tourist.SaveListOfTouristsParams
import com.mywebsite.hotel.models.tourist.Tourist
import com.mywebsite.hotel.usecase.booking.GetBookingInfoUseCase
import com.mywebsite.hotel.usecase.hotel.GetHotelInfoUseCase
import com.mywebsite.hotel.usecase.room.GetListOfRoomsUseCase
import com.mywebsite.hotel.usecase.tourist.AddTouristUseCase
import com.mywebsite.hotel.usecase.tourist.ObserveAllTouristsUseCase
import com.mywebsite.hotel.usecase.tourist.SaveListOfTouristsUseCase
import com.mywebsite.hotel.usecase.utils.CreateInitialTouristsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getHotelInfoUseCase: GetHotelInfoUseCase,
    private val getListOfRoomsUseCase: GetListOfRoomsUseCase,
    private val getBookingInfoUseCase: GetBookingInfoUseCase,
    private val addTouristUseCase: AddTouristUseCase,
    private val saveListOfTouristsUseCase: SaveListOfTouristsUseCase,
    private val observeAllTouristsUseCase: ObserveAllTouristsUseCase
) : ViewModel() {

// 1. Variables_____________________________________________________________________________________

    val emailFocusRequester = FocusRequester()
    val phoneFocusRequester = FocusRequester()

// 2. ObserverVariables_____________________________________________________________________________

    private val _vmHotel = MutableStateFlow(Hotel())
    val vmHotel: StateFlow<Hotel> = _vmHotel

    private val _vmListOfRoom = MutableStateFlow(listOf<Room>())
    val vmListOfRoom: StateFlow<List<Room>> = _vmListOfRoom

    private val _vmBooking = MutableStateFlow(Booking())
    val vmBooking: StateFlow<Booking> = _vmBooking

    private val _vmEmail = MutableStateFlow("examplemail.000@mail.ru")
    val vmEmail: StateFlow<String> = _vmEmail
    fun onEmailChange(value: String) {
        _vmEmail.value = value
    }

    private val _vmEmailIsError = MutableStateFlow(false)
    val vmEmailIsError: StateFlow<Boolean> = _vmEmailIsError
    fun setEmailIsError(value: Boolean) {
        _vmEmailIsError.value = value
    }

    private val _vmPhone = MutableStateFlow("")
    val vmPhone: StateFlow<String> = _vmPhone
    fun onPhoneChange(value: String) {
        _vmPhone.value = value
    }

    private val _vmPhoneIsError = MutableStateFlow(false)
    val vmPhoneIsError: StateFlow<Boolean> = _vmPhoneIsError
    fun setPhoneIsError(value: Boolean) {
        _vmPhoneIsError.value = value
    }

    val mapOfEditedTourists = mapOf<String, Tourist>()
    private val _vmTouristList = MutableStateFlow(listOf<Tourist>())
    val vmTouristList: StateFlow<List<Tourist>> = _vmTouristList

// 3. Utils_________________________________________________________________________________________

    init {
        getHotelInfo()
        getListOfTourists()
    }

    fun validatePhoneIsRight(): Boolean {
        return vmPhone.value.let {
            it.length == 10 && Patterns.PHONE.matcher(it).matches()
        }
    }

    fun validateEmailIsRight(): Boolean {
        return vmEmail.value.let { it.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(it).matches() }
    }

// 4. Buttons_______________________________________________________________________________________

    fun onEmailKeyBoardClicked() {
        phoneFocusRequester.requestFocus()
    }

    fun onPhoneKeyBoardClicked() {
        emailFocusRequester.requestFocus()
    }

// 5. DomainInteraction_____________________________________________________________________________

    private fun getHotelInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            getHotelInfoUseCase.invoke()?.let {
                _vmHotel.value = it
            }
        }
    }

    fun getListOfRooms() {
        viewModelScope.launch(Dispatchers.IO) {
            val temp = getListOfRoomsUseCase.invoke()
            if (vmListOfRoom.value.isEmpty()) _vmListOfRoom.value = temp
        }
    }

    fun getBookingInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            getBookingInfoUseCase.invoke()?.let {
                _vmBooking.value = it
            }
        }
    }

    fun addTourist() {
        viewModelScope.launch(Dispatchers.IO) {
            if (vmTouristList.value.size < 10) addTouristUseCase.invoke(AddTouristParams(Tourist()))
        }
    }

    fun saveListOfTourists() {
        viewModelScope.launch(Dispatchers.IO) {
            saveListOfTouristsUseCase.invoke(SaveListOfTouristsParams(vmTouristList.value))
        }
    }

    private fun getListOfTourists() {
        viewModelScope.launch(Dispatchers.IO) {
            observeAllTouristsUseCase.invoke().collect {
                _vmTouristList.value = it

                if (it.isEmpty()) {
                    saveListOfTouristsUseCase.invoke(SaveListOfTouristsParams(CreateInitialTouristsUseCase().invoke()))
                }
            }
        }
    }
}