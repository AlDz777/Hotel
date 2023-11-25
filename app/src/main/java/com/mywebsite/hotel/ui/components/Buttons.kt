package com.mywebsite.hotel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mywebsite.hotel.R

@Composable
fun ButtonSimple(
    mText: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.button)),
    mOnClick: () -> Unit,
    modifier: Modifier = Modifier
        .clip(RoundedCornerShape(15.dp))
        .fillMaxWidth()
        .padding(vertical = 15.dp)
        .height(48.dp)
) {
    Button(
        modifier = modifier,
        colors = buttonColors,
        shape = RoundedCornerShape(12.dp),
        onClick = mOnClick
    ) {
        Text(textAlign = TextAlign.Center, text = mText, fontSize = 16.sp)
    }
}

@Composable
fun ButtonTextWithRightIcon(
    mText: String,
    iconRight: Painter = painterResource(R.drawable.ic_arrow_forward),
    modifier: Modifier = Modifier
        .clip(RoundedCornerShape(5.dp))
        .background(color = colorResource(R.color.blue_special).copy(alpha = 0.1f))
        .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 2.dp)
        .height(29.dp)
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = mText,
            fontSize = 16.sp,
            color = colorResource(R.color.blue_special),
        )
        Icon(painter = iconRight,
            contentDescription = null,
            tint = colorResource(R.color.blue_special))
    }
}