package com.mywebsite.hotel.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun HeaderSlider(
//    modifier: Modifier = Modifier,
//    sliderList: List<String>,
//    backwardIcon: ImageVector = Icons.Default.KeyboardArrowLeft,
//    forwardIcon: ImageVector = Icons.Default.KeyboardArrowRight,
//    dotsActiveColor: Color = Color.DarkGray,
//    dotsInActiveColor: Color = Color.LightGray,
//    dotsSize: Dp = 10.dp,
//    pagerPaddingValues: PaddingValues = PaddingValues(horizontal = 65.dp),
//    imageCornerRadius: Dp = 16.dp,
//    imageHeight: Dp = 250.dp,
//) {
//
//    val pagerState = rememberPagerState { sliderList.size }
////    HorizontalPager(
////        state = pagerState,
////        modifier = Modifier.fillMaxSize()
////    ) { page ->
////        // page count
////    }
//
//    val scope = rememberCoroutineScope()
//
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
//    ) {
//        Row(
//            modifier = modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Center,
//        ) {
//
//            IconButton(enabled = pagerState.canScrollBackward, onClick = {
//                scope.launch {
//                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
//                }
//            }) {
//                Icon(imageVector = backwardIcon, contentDescription = "back")
//            }
//
//
//            HorizontalPager(
////                pageCount = sliderList.size,
//                state = pagerState,
//                contentPadding = pagerPaddingValues,
//                modifier = modifier,
////                pageSize = PageSize.Fill
//            ) { page ->
//                val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
//
//                val scaleFactor = 0.75f + (1f - 0.75f) * (1f - pageOffset.absoluteValue)
//
//
//                Box(modifier = modifier
//                    .graphicsLayer {
//                        scaleX = scaleFactor
//                        scaleY = scaleFactor
//                    }
//                    .alpha(
//                        scaleFactor.coerceIn(0f, 1f)
//                    )
//                    .padding(10.dp)
//                    .clip(RoundedCornerShape(imageCornerRadius))) {
//                    if (sliderList.isNotEmpty()) {
//                        LoadImage(path = sliderList[page], modifier = modifier
//                            .height(imageHeight)
//                            .alpha(if (pagerState.currentPage == page) 1f else 0.5f))
//                    }
////                    LoadImage(path = sliderList[page], modifier = modifier.height(imageHeight).alpha(if (pagerState.currentPage == page) 1f else 0.5f))
////                    AsyncImage(
////                        model = ImageRequest.Builder(LocalContext.current).scale(Scale.FILL)
////                            .crossfade(true).data(sliderList[page]).build(),
////                        contentDescription = "Image",
////                        contentScale = ContentScale.Crop,
////                        placeholder = painterResource(id = R.drawable.ic_launcher_background),
////                        modifier = modifier.height(imageHeight)
//////                            .alpha(if (pagerState.currentPage == page) 1f else 0.5f)
////                    )
//                }
//            }
//
//            IconButton(enabled = pagerState.currentPage != sliderList.size - 1, onClick = {
//                scope.launch {
//                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
//                }
//            }) {
//                Icon(imageVector = forwardIcon, contentDescription = "forward")
//            }
//        }
//
//        Row(
//            modifier
//                .height(50.dp)
//                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
//        ) {
//            Row(modifier = Modifier
//                .background(Color.Magenta)
//                .clip(RoundedCornerShape(50.dp))
//            ) {
//                repeat(sliderList.size) {
//                    val color = if (pagerState.currentPage == it) dotsActiveColor else dotsInActiveColor
//                    Box(modifier = modifier
//                        .padding(2.dp)
//                        .clip(CircleShape)
//                        .size(dotsSize)
//                        .background(color)
//                        .clickable {
//                            scope.launch {
//                                pagerState.animateScrollToPage(it)
//                            }
//                        })
//                }
//            }
//        }
//    }
//}

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun ImageSlider2(sliderList: List<String>) {
//    val pagerState = rememberPagerState()
//    val scope = rememberCoroutineScope()
//    Box(modifier = Modifier.fillMaxSize()) {
//        HorizontalPager(
//            pageCount = animals.size,
//            state = pagerState,
//            key = { animals[it] },
//            pageSize = PageSize.Fill
//        ) { index ->
//            Image(
//                painter = painterResource(id = animals[index]),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
//        }
//        Box(
//            modifier = Modifier
//                .offset(y = -(16).dp)
//                .fillMaxWidth(0.5f)
//                .clip(RoundedCornerShape(100))
//                .background(MaterialTheme.colorScheme.background)
//                .padding(8.dp)
//                .align(Alignment.BottomCenter)
//        ) {
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(
//                            pagerState.currentPage - 1
//                        )
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterStart)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "Go back"
//                )
//            }
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(
//                            pagerState.currentPage + 1
//                        )
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowRight,
//                    contentDescription = "Go forward"
//                )
//            }
//        }
//    }
//}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderSlider(
    modifier: Modifier = Modifier,
    sliderList: List<String>,
    dotsActiveColor: Color = Color.DarkGray,
    dotsInActiveColor: Color = Color.LightGray,
    dotsSize: Dp = 10.dp,
) {
    val pagerState = rememberPagerState { sliderList.size }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            pageSize = PageSize.Fill
        ) { index ->
            if (sliderList.isNotEmpty()) {
                LoadImage(
                    path = sliderList[index],
                    modifier = modifier
                        .width(343.dp)
                        .height(257.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
//            Image(
//                painter = painterResource(id = animals[index]),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.fillMaxSize()
//            )
            }
        }
        Row(modifier = Modifier
//            .offset(y = -(16).dp)
//            .height(50.dp)
//            .background(Color.White)
//            .clip(RoundedCornerShape(50.dp))
//            .offset(y = -(16).dp)
//            .fillMaxWidth(0.5f)
            .offset(y = -(16).dp)
            .wrapContentWidth()
            .clip(RoundedCornerShape(20))
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(sliderList.size) {
                val color = if (pagerState.currentPage == it) dotsActiveColor else dotsInActiveColor
                Box(modifier = modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .size(dotsSize)
                    .background(color)
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(it)
                        }
                    })
            }
        }


//        Row(
//            modifier
//                .offset(y = -(16).dp)
//                .height(50.dp)
//                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
//        ) {
//
//        }
//        Box(
//            modifier = Modifier
//                .offset(y = -(16).dp)
//                .fillMaxWidth(0.5f)
//                .clip(RoundedCornerShape(100))
//                .background(MaterialTheme.colorScheme.background)
//                .padding(8.dp)
//                .align(Alignment.BottomCenter)
//        ) {
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(
//                            pagerState.currentPage - 1
//                        )
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterStart)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowLeft,
//                    contentDescription = "Go back"
//                )
//            }
//            IconButton(
//                onClick = {
//                    scope.launch {
//                        pagerState.animateScrollToPage(
//                            pagerState.currentPage + 1
//                        )
//                    }
//                },
//                modifier = Modifier.align(Alignment.CenterEnd)
//            ) {
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowRight,
//                    contentDescription = "Go forward"
//                )
//            }
//        }
    }
}