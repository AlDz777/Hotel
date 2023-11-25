package com.mywebsite.hotel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mywebsite.hotel.R
import com.mywebsite.hotel.ui.components.BottomWithButton
import com.mywebsite.hotel.ui.components.HeaderWithArrowBack
import com.mywebsite.hotel.ui.components.SpacerHeight
import com.mywebsite.hotel.ui.components.TextDescription
import com.mywebsite.hotel.ui.components.TextHeader

@Composable
fun PaidScreen(
    modifier: Modifier = Modifier,
    onNavigateToBookingScreen: () -> Unit,
    onNavigateToBaseScreen: () -> Unit
) {

    Column(modifier = modifier) {
        HeaderWithArrowBack(stringResource(R.string.paid_order_is_paid), onNavigateToBookingScreen)
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .weight(1.0f)
            .padding(horizontal = dimensionResource(R.dimen.screen_horizontal)), contentAlignment = Alignment.Center) {
            PaidBox1()
        }
        SpacerHeight(height = 1.dp)
        BottomWithButton(stringResource(R.string.paid_super), onClick = onNavigateToBaseScreen)
    }
}

@Composable
fun PaidBox1() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        SpacerHeight(122.dp)
        PaidPartyIcon()
//        SpacerHeight(32.dp)
        TextHeader(stringResource(R.string.paid_order_accepted))
//        SpacerHeight(20.dp)
        TextDescription(stringResource(R.string.paid_order_description), color = colorResource(R.color.grey_text), textAlign = TextAlign.Center)
    }
}

@Composable
fun PaidPartyIcon() {
    Box(modifier = Modifier
        .size(94.dp)
        .clip(shape = CircleShape)
        .background(colorResource(R.color.grey_box_light)),
    contentAlignment = Alignment.Center) {
        Image(painter = painterResource(R.drawable.party_popper), contentDescription = null, modifier = Modifier.size(44.dp))
    }
}

