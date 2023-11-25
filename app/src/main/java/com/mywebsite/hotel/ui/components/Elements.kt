package com.mywebsite.hotel.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mywebsite.hotel.R
import com.mywebsite.hotel.models.hotel.Hotel

@Composable
fun HeaderWithArrowBack(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 16.dp, top = 19.dp, start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ImageClickable(painterResource(R.drawable.ic_arrow_back), mOnClick = onClick)
        TextFragmentHeader(text, modifier = Modifier.weight(1f))
    }
}

@Composable
fun BottomWithButton(text: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = dimensionResource(R.dimen.screen_horizontal), vertical = 12.dp)
            .fillMaxSize()
    ) {
        ButtonSimple(mText = text, mOnClick = onClick)
    }
}

@Composable
fun StarText(rating: Int, ratingName: String) {

    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(20))
                .background(colorResource(R.color.rating).copy(0.2f))
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = null,
                tint = colorResource(R.color.rating),
                modifier = Modifier
                    .height(15.dp)
                    .width(15.dp)
            )
            TextRating(text = rating.toString())
            Spacer(modifier = Modifier.width(4.dp))
            TextRating(text = ratingName.toString())
        }
    }
}

@Composable
fun TouristHeader(text: String,
                  icon: ImageVector = Icons.Filled.KeyboardArrowUp,
                  contentDescription: String? = null,
                  modifier: Modifier = Modifier,
                  boxModifier: Modifier = Modifier.clip(RoundedCornerShape(6.dp)).background(colorResource(R.color.blue_special).copy(alpha = 0.1f)),
                  iconTint: Color = colorResource(R.color.blue_special),
                  iconOnClick: () -> Unit = {}) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically , horizontalArrangement = Arrangement.SpaceBetween) {
        TextHeader(text = text)
        Box(
            modifier = boxModifier
                ,

            contentAlignment = Alignment.Center,

        ) {
            Icon(imageVector = icon, contentDescription = contentDescription, tint = iconTint, modifier = Modifier.size(24.dp).clickable(onClick = iconOnClick))
        }
    }
}