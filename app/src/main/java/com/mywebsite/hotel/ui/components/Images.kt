package com.mywebsite.hotel.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mywebsite.hotel.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LoadImage(path: String, modifier: Modifier = Modifier) {
    GlideImage(model = path,
        contentScale = ContentScale.Crop,
        contentDescription = "loadImage",
        modifier = modifier.fillMaxSize()) {
        it.error(R.drawable.background_white)
            .placeholder(R.drawable.background_white)
            .load(path)
    }
}

@Composable
fun ImageClickable(mPainter: Painter, mOnClick: () -> Unit, mContentDescription: String? = null) {
    Image(
        painter = mPainter,
        contentDescription = mContentDescription,
        modifier = Modifier
            .clickable(
                role = Role.Button,
                onClick = mOnClick
            )
    )
}