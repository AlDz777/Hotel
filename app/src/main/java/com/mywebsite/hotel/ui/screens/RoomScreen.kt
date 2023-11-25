package com.mywebsite.hotel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mywebsite.hotel.MainViewModel
import com.mywebsite.hotel.R
import com.mywebsite.hotel.models.room.Room
import com.mywebsite.hotel.ui.components.ButtonSimple
import com.mywebsite.hotel.ui.components.ButtonTextWithRightIcon
import com.mywebsite.hotel.ui.components.HeaderSlider
import com.mywebsite.hotel.ui.components.HeaderWithArrowBack
import com.mywebsite.hotel.ui.components.ImageClickable
import com.mywebsite.hotel.ui.components.SpacerHeight
import com.mywebsite.hotel.ui.components.SpacerWidth
import com.mywebsite.hotel.ui.components.TextFragmentHeader
import com.mywebsite.hotel.ui.components.TextHeader
import com.mywebsite.hotel.ui.components.TextPeculiarities
import com.mywebsite.hotel.ui.components.TextPriceAndDescription

@Composable
fun RoomScreen(
    modifier: Modifier = Modifier,
    onNavigateToHotelScreen: () -> Unit,
    onNavigateToBookingScreen: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.getListOfRooms()

    Column(modifier = modifier) {
        HeaderWithArrowBack(stringResource(R.string.room_header), onNavigateToHotelScreen)
        SpacerHeight(8.dp)
        RoomBox2(viewModel, onNavigateToBookingScreen)
    }
}

@Composable
fun RoomBox2(viewModel: MainViewModel, onNavigateToBookingScreen: () -> Unit) {
    val listOfRooms = viewModel.vmListOfRoom.collectAsState()
    val oneCardSize = 539.dp

    LazyColumn(
        modifier = Modifier
            .height(oneCardSize * listOfRooms.value.size)
    ) {
        items(listOfRooms.value.size) { index ->
            CreateRoomCard(listOfRooms.value[index], onNavigateToBookingScreen)
            SpacerHeight(8.dp)
        }
    }
}

@Composable
fun CreateRoomCard(room: Room, onNavigateToBookingScreen: () -> Unit) {
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
        HeaderSlider(sliderList = room.imageUrls)
        SpacerHeight(8.dp)
        TextHeader(room.name ?: "")
        SpacerHeight(8.dp)
        RoomPeculiarities(room.peculiarities)
        SpacerHeight(8.dp)
        ButtonTextWithRightIcon(mText = stringResource(R.string.room_detail))
        SpacerHeight(16.dp)
        RoomPrice(room)
        ButtonSimple(mText = stringResource(R.string.room_button), mOnClick = onNavigateToBookingScreen)
    }
}

@Composable
fun RoomPeculiarities(peculiarities: List<String>) {
    if (peculiarities.isNotEmpty()) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            TextPeculiarities(peculiarities[0], modifier = Modifier.weight(0.5f))
            SpacerWidth(18.dp)
            if (peculiarities.size > 1) TextPeculiarities(peculiarities[1], modifier = Modifier.weight(0.5f))
        }
        if (peculiarities.size > 2) Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (peculiarities.size > 2) TextPeculiarities(peculiarities[2], modifier = Modifier.weight(0.5f))
            if (peculiarities.size > 3) TextPeculiarities(peculiarities[3], modifier = Modifier.weight(0.5f))
        }
    }
}

@Composable
fun RoomPrice(room: Room) {
    Row {
        TextPriceAndDescription(
            price = (room.price ?: "").toString(),
            description = room.pricePer?.lowercase() ?: "")
    }
}