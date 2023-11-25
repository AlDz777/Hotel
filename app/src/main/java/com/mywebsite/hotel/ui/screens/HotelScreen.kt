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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mywebsite.hotel.MainViewModel
import com.mywebsite.hotel.R
import com.mywebsite.hotel.models.hotel.Hotel
import com.mywebsite.hotel.ui.components.BottomWithButton
import com.mywebsite.hotel.ui.components.DividerHorizontal
import com.mywebsite.hotel.ui.components.HeaderSlider
import com.mywebsite.hotel.ui.components.SpacerHeight
import com.mywebsite.hotel.ui.components.SpacerWidth
import com.mywebsite.hotel.ui.components.StarText
import com.mywebsite.hotel.ui.components.TextDescription
import com.mywebsite.hotel.ui.components.TextFeatures
import com.mywebsite.hotel.ui.components.TextFragmentHeader
import com.mywebsite.hotel.ui.components.TextHeader
import com.mywebsite.hotel.ui.components.TextLinked
import com.mywebsite.hotel.ui.components.TextPeculiarities
import com.mywebsite.hotel.ui.components.TextPriceAndDescription
import com.mywebsite.hotel.ui.components.TextRating

@Composable
fun HotelScreen(
    modifier: Modifier = Modifier,
    onNavigateToRoomScreen: () -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {

    Column(modifier = modifier) {
        HotelBox1(viewModel)
        SpacerHeight(8.dp)
        HotelBox2(viewModel)
        SpacerHeight(12.dp)
        BottomWithButton(stringResource(R.string.hotel_button), onNavigateToRoomScreen)
    }
}

@Composable
fun HotelBox1(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    bottomEnd = 12.dp,
                    bottomStart = 12.dp
                )
            )
            .background(Color.White)
            .padding(horizontal = dimensionResource(R.dimen.screen_horizontal), vertical = 19.dp)
    ) {
        val hotel = viewModel.vmHotel.collectAsState()

        HotelMainHeader()
        SpacerHeight(16.dp)
        HotelImageSlider(hotel)
        SpacerHeight(16.dp)
        StarText(hotel.value.rating ?: 5, hotel.value.ratingName ?: "")
        SpacerHeight(8.dp)
        HotelName(hotel)
        SpacerHeight(8.dp)
        HotelAddress(hotel)
        SpacerHeight(16.dp)
        HotelPrice(hotel)
    }
}

@Composable
fun HotelBox2(viewModel: MainViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .padding(horizontal = dimensionResource(R.dimen.screen_horizontal), vertical = dimensionResource(R.dimen.screen_vertical))
            .fillMaxSize()
    ) {
        val hotel = viewModel.vmHotel.collectAsState()

        AboutHotel()
        SpacerHeight(16.dp)
        HotelPeculiarities(hotel)
        SpacerHeight(16.dp)
        HotelDescription(hotel)
        SpacerHeight(12.dp)
        HotelFeatures()
    }
}

@Composable
fun HotelMainHeader() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        TextFragmentHeader(stringResource(R.string.hotel_header))
    }
}

@Composable
fun HotelImageSlider(hotel: State<Hotel>) {
    HeaderSlider(sliderList = hotel.value.imageUrls)
}

@Composable
fun HotelName(hotel: State<Hotel>) {
    TextHeader(hotel.value.name ?: "")
}

@Composable
fun HotelAddress(hotel: State<Hotel>) {
    TextLinked(hotel.value.adress ?: "")
}

@Composable
fun HotelPrice(hotel: State<Hotel>) {
    Row {
        TextPriceAndDescription(
            price = (hotel.value.minimalPrice ?: "").toString(),
            description = hotel.value.priceForIt?.lowercase() ?: "")

    }
}

@Composable
fun AboutHotel() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
        TextHeader(stringResource(R.string.about_hotel))
    }
}

@Composable
fun HotelPeculiarities(hotel: State<Hotel>) {
    val peculiarities = hotel.value.aboutTheHotel?.peculiarities
    peculiarities?.let {
        if (it.isNotEmpty()) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                val shortFirstFeature = it[0].substring(0, it[0].indexOf("Wifi") + 4)
                TextPeculiarities(shortFirstFeature, modifier = Modifier)
                SpacerWidth(8.dp)
                if (it.size > 1) TextPeculiarities(it[1], modifier = Modifier)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (it.size > 2) TextPeculiarities(it[2], modifier = Modifier.weight(0.5f))
                if (it.size > 3) TextPeculiarities(it[3], modifier = Modifier.weight(0.5f))
            }
        }
    }
}

@Composable
fun HotelDescription(hotel: State<Hotel>) {
    TextDescription(text = hotel.value.aboutTheHotel?.description ?: "")
}

@Composable
fun HotelFeatures() {
    Column(modifier = Modifier
        .clip(RoundedCornerShape(15.dp))
        .background(colorResource(R.color.grey_box))
        .padding(15.dp)
    ) {
        TextFeatures(
            title = stringResource(R.string.hotel_feature_1_title),
            description = stringResource(R.string.hotel_feature_1_descr),
            iconLeft = painterResource(R.drawable.ic_happy))
        DividerHorizontal(modifier = Modifier.padding(start = 34.dp, end = 0.dp, top = 10.dp, bottom = 10.dp))
        TextFeatures(
            title = stringResource(R.string.hotel_feature_2_title),
            description = stringResource(R.string.hotel_feature_2_descr),
            iconLeft = painterResource(R.drawable.ic_tick))
        DividerHorizontal(modifier = Modifier.padding(start = 34.dp, end = 0.dp, top = 10.dp, bottom = 10.dp))
        TextFeatures(
            title = stringResource(R.string.hotel_feature_3_title),
            description = stringResource(R.string.hotel_feature_3_descr),
            iconLeft = painterResource(R.drawable.ic_close))
    }
}

@Preview(showSystemUi = true)
@Composable
fun HotelPreview() {
    HotelScreen(Modifier, hiltViewModel())
}