package com.mywebsite.hotel.ui.components

import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mywebsite.hotel.R

@Composable
fun DividerHorizontal(thickness: Dp = 1.dp, color: Color = colorResource(R.color.grey_text).copy(alpha = 0.15f), modifier: Modifier = Modifier) {
    Divider(thickness = thickness, color = color, modifier = modifier)
}