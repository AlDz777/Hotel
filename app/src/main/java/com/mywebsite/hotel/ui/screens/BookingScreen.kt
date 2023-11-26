package com.mywebsite.hotel.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mywebsite.hotel.MainViewModel
import com.mywebsite.hotel.R
import com.mywebsite.hotel.models.tourist.Tourist
import com.mywebsite.hotel.models.booking.Booking
import com.mywebsite.hotel.ui.components.BottomWithButton
import com.mywebsite.hotel.ui.components.HeaderWithArrowBack
import com.mywebsite.hotel.ui.components.SpacerHeight
import com.mywebsite.hotel.ui.components.StarText
import com.mywebsite.hotel.ui.components.TextFieldEmail
import com.mywebsite.hotel.ui.components.TextFieldPhone
import com.mywebsite.hotel.ui.components.TextFieldSimple
import com.mywebsite.hotel.ui.components.TextHeader
import com.mywebsite.hotel.ui.components.TextLinked
import com.mywebsite.hotel.ui.components.TextPrivacy
import com.mywebsite.hotel.ui.components.TextTwoInRowWithGreyAndBlackColor
import com.mywebsite.hotel.ui.components.TouristHeader

@Composable
fun BookingScreen(
    modifier: Modifier = Modifier,
    onNavigateToRoomScreen: () -> Unit,
    onNavigateToPaidScreen: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.getBookingInfo()

    val booking = viewModel.vmBooking.collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HeaderWithArrowBack(stringResource(R.string.room_header), onNavigateToRoomScreen)
        BookingBox2HotelData(booking)
        BookingBox3Details(booking)
        BookingBox4Buyer(viewModel)
        ListOfTourists(viewModel)
//        BookingTouristBoxCreator()
//        BookingBox6()
        BookingBox7AddTourist(viewModel)
        BookingBox8Fee(booking)
        BookingBox9PayButton(booking, onNavigateToPaidScreen, viewModel)
    }
}

@Composable
fun BookingBox2HotelData(booking: State<Booking>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        StarText(booking.value.horating ?: 5, booking.value.ratingName ?: "")
        TextHeader(booking.value.hotelName ?: "")
        TextLinked(booking.value.hotelAdress ?: "")
    }
}


@Composable
fun BookingBox3Details(booking: State<Booking>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val dateStartTo = (booking.value.tourDateStart ?: "") + "-" + (booking.value.tourDateStop ?: "")

        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_departure), booking.value.departure ?: "")
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_country_city), booking.value.arrivalCountry ?: "")
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_dates), dateStartTo ?: "")
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_number_nights), pluralStringResource(R.plurals.plurals_nights, booking.value.numberOfNights ?: 7, booking.value.numberOfNights ?: 7))
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_hotel), booking.value.hotelName ?: "")
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_room), booking.value.room ?: "")
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_nutrition), booking.value.nutrition ?: "")
    }
}


@Composable
fun BookingBox4Buyer(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            )
    ) {

        val email = viewModel.vmEmail.collectAsState(initial = "")
        val emailFocusRequester = viewModel.emailFocusRequester
        val emailIsError = viewModel.vmEmailIsError.collectAsState(initial = false)

        val phone = viewModel.vmPhone.collectAsState(initial = "")
        val phoneFocusRequester = viewModel.phoneFocusRequester
        val phoneIsError = viewModel.vmPhoneIsError.collectAsState(initial = false)


        TextHeader(stringResource(R.string.booking_info_about_buyer))
        SpacerHeight(20.dp)
        TextFieldPhone(
            mValue = phone.value,
            mOnValueChanged = { newText: String ->
                viewModel.onPhoneChange(newText)
                viewModel.setPhoneIsError(false)
            },
            mFocusRequester = phoneFocusRequester,
            mKeyboardActions = KeyboardActions(onNext = { viewModel.onPhoneKeyBoardClicked() }),
            mIsError = phoneIsError.value
        )
        SpacerHeight(8.dp)
        TextFieldEmail(
            mValue = email.value,
            mOnValueChanged = { newText: String ->
                viewModel.onEmailChange(newText)
                viewModel.setEmailIsError(false)
            },
            mFocusRequester = emailFocusRequester,
            mKeyboardActions = KeyboardActions(onNext = { viewModel.onEmailKeyBoardClicked() }),
            mIsError = emailIsError.value
        )
        SpacerHeight(8.dp)
        TextPrivacy(stringResource(R.string.booking_privacy))
    }
}

@Composable
fun ListOfTourists(viewModel: MainViewModel) {
    val tourists = viewModel.vmTouristList.collectAsState()

    val oneCardSize = 430.dp

//    val scanLowEnergyDevices by lazy { mutableStateListOf<ScanResult>() }

    val touristsHeaderArray = stringArrayResource(R.array.booking_tourist_counter)

    var parentHeight by remember { mutableStateOf(0) }
    var listHeight by remember { mutableStateOf(0) }

    Column(modifier= Modifier
        .fillMaxSize()
        .onSizeChanged {
            parentHeight = it.height
            listHeight = it.height
        }) {

        for (index in 0..tourists.value.size.minus(1)) {
            SpacerHeight(8.dp)
            BookingTouristBoxCreator(touristsHeaderArray[index], index, tourists.value[index])
        }

//        LazyColumn(
//            modifier = Modifier.height(oneCardSize * touristQuantity.value).onSizeChanged {
//                listHeight = it.height
//                }
////            .height(oneCardSize * touristQuantity.value + spacerSize * touristQuantity.value.minus(1))
//        ) {
//            items(touristQuantity.value) { index ->
////                SpacerHeight(8.dp)
//                BookingTouristBoxCreator(touristsHeaderArray[index], mIsVisible = index == 0)
//            }
//        }
    }
//    for (index in 0..touristQuantity.value.minus(1)) {
//        BookingTouristBoxCreator(touristsHeaderArray[index], mIsVisible = index == 0)
//    }

//    var parentHeight by remember { mutableStateOf(0) }
//    var listHeight by remember { mutableStateOf(0) }

//    Column(modifier=Modifier.fillMaxSize()
//        .onSizeChanged {
//            parentHeight = it.height
//        }) {
//        LazyColumn(
//            modifier = Modifier.height(oneCardSize * touristQuantity.value).onSizeChanged {
//                listHeight = it.height
//                }
////            .height(oneCardSize * touristQuantity.value + spacerSize * touristQuantity.value.minus(1))
//        ) {
//            items(touristQuantity.value) { index ->
////                SpacerHeight(8.dp)
//                BookingTouristBoxCreator(touristsHeaderArray[index], mIsVisible = index == 0)
//            }
//        }
//    }
}

@Composable
fun BookingTouristBoxCreator(header: String, index: Int, currentTourist: Tourist) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            )
    ) {
        var isVisible by remember { mutableStateOf(index == 0) }

        var icon by remember { mutableStateOf(if (isVisible) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown) }

        TouristHeader(header, icon, iconOnClick = { isVisible = !isVisible } )
        SpacerHeight(20.dp)

        val firstName = remember{ mutableStateOf(currentTourist.firstName) }
        val lastName = remember{ mutableStateOf(currentTourist.lastName) }
        val dayOfBirth = remember{ mutableStateOf(currentTourist.dayOfBirth) }
        val citizenship = remember{ mutableStateOf(currentTourist.citizenship) }
        val passportNum = remember{ mutableStateOf(currentTourist.passportNum) }
        val passportValidation = remember{ mutableStateOf(currentTourist.passportValidation) }

        if (isVisible) {
            icon = Icons.Filled.KeyboardArrowUp
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextFieldSimple(labelText = stringResource(R.string.booking_first_name), value = firstName.value, onValueChanged = { newText: String ->
                    firstName.value = newText ; currentTourist.firstName = newText })
                TextFieldSimple(labelText = stringResource(R.string.booking_last_name), value = lastName.value, onValueChanged = { newText ->
                    lastName.value = newText ; currentTourist.lastName = newText } )
                TextFieldSimple(labelText = stringResource(R.string.booking_day_of_birth), value = dayOfBirth.value, onValueChanged = { newText ->
                    dayOfBirth.value = newText ; currentTourist.dayOfBirth = newText } )
                TextFieldSimple(labelText = stringResource(R.string.booking_citizenship), value = citizenship.value, onValueChanged = { newText ->
                    citizenship.value = newText ; currentTourist.citizenship = newText } )
                TextFieldSimple(labelText = stringResource(R.string.booking_passport_number), value = passportNum.value, onValueChanged = { newText ->
                    passportNum.value = newText ; currentTourist.passportNum = newText } )
                TextFieldSimple(labelText = stringResource(R.string.booking_passport_validity_period), value = passportValidation.value, onValueChanged = { newText ->
                    passportValidation.value = newText ; currentTourist.passportValidation = newText } )
            }
        } else {
            icon = Icons.Filled.KeyboardArrowDown
        }
    }
}

@Composable
fun BookingBox7AddTourist(viewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            )
    ) {
        TouristHeader(stringResource(R.string.booking_add_tourist),
            icon = Icons.Filled.Add,
            boxModifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(colorResource(R.color.blue_special)),
            iconTint = colorResource(R.color.white),
            iconOnClick = { viewModel.addTourist() }
        )
    }
}

@Composable
fun BookingBox8Fee(booking: State<Booking>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(
                horizontal = dimensionResource(R.dimen.screen_horizontal),
                vertical = dimensionResource(R.dimen.screen_vertical)
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val ruble = " " + stringResource(R.string.ruble)
        val totalPrice = ((booking.value.tourPrice ?: 0) + (booking.value.fuelCharge ?: 0) + (booking.value.serviceCharge ?: 0)).toString()


        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_tour), (booking.value.tourPrice?.toString() ?: "0") + ruble, isTextsPlacedToTheEnd = true)
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_fuel_surcharge), (booking.value.fuelCharge?.toString() ?: "0") + ruble, isTextsPlacedToTheEnd = true)
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_service_fee), (booking.value.serviceCharge?.toString() ?: "0") + ruble, isTextsPlacedToTheEnd = true)
        TextTwoInRowWithGreyAndBlackColor(stringResource(R.string.booking_payable), totalPrice + ruble, color2 = colorResource(R.color.blue_special), isTextsPlacedToTheEnd = true)
    }
}

@Composable
fun BookingBox9PayButton(
    booking: State<Booking>,
    onNavigateToPaidScreen: () -> Unit,
    viewModel: MainViewModel
) {
    val totalPrice = ((booking.value.tourPrice ?: 0) + (booking.value.fuelCharge ?: 0) + (booking.value.serviceCharge ?: 0)).toString() + " " + stringResource(R.string.ruble)
    val text = stringResource(R.string.booking_pay) + " " + totalPrice

    var invalidPhoneToast by remember { mutableStateOf(false) }
    var invalidEmailToast by remember { mutableStateOf(false) }

    val navigateFunc: () -> Unit = {
        when {
            !viewModel.validatePhoneIsRight() -> {
                viewModel.setPhoneIsError(true)
                invalidPhoneToast = true

//                dismissDialog = true
//                if (dismissDialog) {
//                    AlertDialogPattern(
//                        dialogText = stringResource(R.string.booking_invalid_phone),
//                        dialogTitle = stringResource(R.string.booking_provide_valid_phone),
//                        onDismissRequest = { dismissDialog = false },
//                        onConfirmation = { dismissDialog = false }
//                    )
//                }
            }
            !viewModel.validateEmailIsRight() -> {
                viewModel.setEmailIsError(true)
                invalidEmailToast = true
            }
            else -> {
                viewModel.saveListOfTourists()
                onNavigateToPaidScreen()
            }

        }
    }
    BottomWithButton(text, onClick = navigateFunc)

    if (invalidPhoneToast) {
        Toast.makeText(
            LocalContext.current,
            stringResource(R.string.booking_provide_valid_phone),
            Toast.LENGTH_LONG
        ).show()
        invalidPhoneToast = false
    }

    if (invalidEmailToast) {
        Toast.makeText(
            LocalContext.current,
            stringResource(R.string.booking_provide_valid_email),
            Toast.LENGTH_LONG
        ).show()
        invalidEmailToast = false
    }
}


