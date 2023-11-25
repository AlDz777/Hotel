package com.mywebsite.hotel.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mywebsite.hotel.R

@Composable
fun TextFragmentHeader(text: String, modifier: Modifier = Modifier, textAlign: TextAlign? = TextAlign.Center) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        textAlign = textAlign
    )
}

@Composable
fun TextRating(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = colorResource(R.color.rating),
        fontWeight = FontWeight.Bold,
        modifier = modifier
    )
}

@Composable
fun TextHeader(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextLinked(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(id = R.color.link),
        modifier = modifier,
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextPriceAndDescription(price: String, description: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            ) {
                append("${stringResource(R.string.from)} $price ${stringResource(R.string.ruble)}")
            }

            append(" ")

            withStyle(
                style = SpanStyle(
                    fontSize = 16.sp,
                    color = colorResource(R.color.grey_text)
                )
            ) {
                append(description)
            }
        })
    }
}

@Composable
fun TextPeculiarities(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(5.dp))
                .background(colorResource(R.color.grey_box))
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .wrapContentWidth(),
        ) {
            Text(
                text = text,
                modifier = modifier,
                fontSize = 16.sp,
                color = colorResource(R.color.grey_text))
        }
    }
}

@Composable
fun TextDescription(text: String, modifier: Modifier = Modifier, color: Color = Color.Unspecified, textAlign: TextAlign? = null) {
    Text(
        text = text,
        fontSize = 16.sp,
        modifier = modifier,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun TextTitleAndDescription(title: String, description: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = description, fontSize = 14.sp, color = colorResource(R.color.grey_text))
    }
}

@Composable
fun TextFeatures(title: String, description: String, iconLeft: Painter, iconRight: Painter = painterResource(R.drawable.ic_arrow_forward), contentDescription: String? = null) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            iconLeft,
            contentDescription = contentDescription,
            modifier = Modifier.padding(end = 12.dp)
        )
        TextTitleAndDescription(title, description)
        Spacer(Modifier.weight(1f))
        Icon(
            iconRight,
            contentDescription = contentDescription
        )
    }
}

@Composable
fun TextTwoInRowWithGreyAndBlackColor(
    text1: String,
    text2: String,
    color2: Color = Color.Unspecified,
    isTextsPlacedToTheEnd: Boolean = false
) {

    if (isTextsPlacedToTheEnd) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = text1, fontSize = 16.sp, color = colorResource(R.color.grey_text))
            Spacer(modifier = Modifier.weight(1.0f))
            Text(text = text2, fontSize = 16.sp, color = color2)
        }
    } else {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = text1, fontSize = 16.sp, color = colorResource(R.color.grey_text), modifier = Modifier.weight(0.5f))
            Text(text = text2, fontSize = 16.sp, color = color2, modifier = Modifier.weight(0.5f))
        }
    }
}

@Composable
fun TextPrivacy(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 14.sp,
        color = colorResource(R.color.grey_text),
        modifier = modifier
    )
}