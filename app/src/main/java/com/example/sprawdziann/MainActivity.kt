package com.example.sprawdziann

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sprawdziann.ui.theme.SprawdziannTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SprawdziannTheme {
                Column {
                    Text(
                        "Available weather icons:",
                        fontSize = 44.sp,
                        lineHeight = 50.sp,
                        fontWeight = FontWeight.Black,
                        modifier = Modifier.padding(12.dp)
                    )
                    WeatherRow(
                        listOf(
                            WeatherIcon.Cloudy,
                            WeatherIcon.SunnyAndCloudy,
                            WeatherIcon.Sunny,
                            WeatherIcon.Moon,
                            WeatherIcon.MoonClouds
                        )
                    )
                }
            }
        }
    }
}

enum class WeatherIcon(val res: Int) {
    Sunny(R.drawable.ic_sunny),
    Snow(R.drawable.ic_snow),
    SunnyAndCloudy(R.drawable.ic_sunny_and_cloudy),
    Cloudy(R.drawable.ic_cloudy),
    Moon(R.drawable.ic_moon),
    MoonClouds(R.drawable.ic_moon_clouds),
}

@Composable
fun WeatherRow(icons: List<WeatherIcon>) {
    LazyRow(
        modifier = Modifier
            .background(Color(0xFF691996))
            .fillMaxWidth()
            .height(100.dp)
    ) {
        items(icons) { Image(
            painterResource(it.res),
            contentDescription = null,
            modifier = Modifier.padding(10.dp)
        ) }
    }
}