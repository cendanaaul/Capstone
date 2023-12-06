package com.cencen.bloommate.ui.screen.intro

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cencen.bloommate.R
import com.cencen.bloommate.data.SplashScreenData
import com.cencen.bloommate.ui.theme.ButtonCardShape
import com.cencen.bloommate.ui.theme.Montserrat
import com.cencen.bloommate.ui.theme.Poppins
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen() {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize()) {
        val items = ArrayList<SplashScreenData>()
        items.add(
            SplashScreenData(
                R.drawable.flowerblue,
                Color(0xFF9A96d0),
                Color(0xFF9A96d0),
                stringResource(id = R.string.fresh_flower),
                stringResource(id = R.string.sub_fresh_flower)
            )
        )
        items.add(
            SplashScreenData(
                R.drawable.floweryellow,
                Color(0xFFD9A047),
                Color(0xFFD9A047),
                stringResource(id = R.string.fresh_flower2),
                stringResource(id = R.string.sub_fresh_flower2)
            )
        )
        items.add(
            SplashScreenData(
                R.drawable.flowerpink,
                Color(0xFFF0A5B9),
                Color(0xFFF0A5B9),
                stringResource(id = R.string.fresh_flower3),
                stringResource(id = R.string.sub_fresh_flower3)
            )
        )

        val pagerState = rememberPagerState(
            pageCount = items.size,
            initialOffscreenLimit = 2,
            infiniteLoop = false,
            initialPage = 0
        )

        SplashScreenPager(
            item = items,
            pagerState = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 0.dp)
        )
    }


}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreenPager(
    item: List<SplashScreenData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(item[page].backgroundColor),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(
                            id = item[page].image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                            .scale(1f),
                        alignment = Alignment.TopCenter
                    )
                }
            }
        }

        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .graphicsLayer(shadowElevation = 1f),
                shape = ButtonCardShape.large,
            ) {
                Box {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PageIndicator(items = item, currentPage = pagerState.currentPage)
                        Text(
                            text = item[pagerState.currentPage].headText,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, end = 30.dp),
                            color = item[pagerState.currentPage].mainColor,
                            fontFamily = Montserrat,
                            textAlign = TextAlign.Right,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Text(
                            text = item[pagerState.currentPage].subText,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp, start = 40.dp, end = 20.dp),
                            color = Color.Black,
                            fontFamily = Montserrat,
                            textAlign = TextAlign.Left,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Light
                        )
                    }


                }
            }


            Box (
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(30.dp)
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    if (pagerState.currentPage!=2) {

                    }
                    else {
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = item[pagerState.currentPage].mainColor
                            ),
                            contentPadding = PaddingValues(vertical = 12.dp),
                            elevation = ButtonDefaults.elevatedButtonElevation(
                                defaultElevation = 0.dp
                            ),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = stringResource(id = R.string.start),
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = Poppins
                            )
                        }
                    }

                }
            }

        }
    }
}

@Composable
fun PageIndicator(items: List<SplashScreenData>, currentPage: Int) {
    Row (
        modifier = Modifier.padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        repeat(items.size) {
            Indicator(
                isSelected = it == currentPage,
                color = items[it].mainColor
            )
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean, color: Color) {
    val width = animateDpAsState(targetValue = if (isSelected) 40.dp else 10.dp, label = "")

    Box (
        modifier = Modifier
            .padding(4.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) color else Color.Gray.copy(alpha = 0.5f))
    )
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun IntroScreenPreview() {
    val items = listOf(
        SplashScreenData(
            R.drawable.flowerblue,
            Color(0xFF9A96d0),
            Color(0xFF9A96d0),
            stringResource(id = R.string.fresh_flower),
            stringResource(id = R.string.sub_fresh_flower)
        ),
        SplashScreenData(
            R.drawable.floweryellow,
            Color(0xFFD9A047),
            Color(0xFFD9A047),
            stringResource(id = R.string.fresh_flower2),
            stringResource(id = R.string.sub_fresh_flower2)
        ),
        SplashScreenData(
            R.drawable.flowerpink,
            Color(0xFFF0A5B9),
            Color(0xFFF0A5B9),
            stringResource(id = R.string.fresh_flower3),
            stringResource(id = R.string.sub_fresh_flower3)
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    SplashScreenPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp)
    )
}
