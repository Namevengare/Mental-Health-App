package com.example.mentalhealthapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mentalhealthapp.R


@Preview(showBackground = true)
@Composable
fun MentalHealthBanner(modifier: Modifier = Modifier) {
    val icon = painterResource(R.drawable.fruit_15467270)
    Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .padding(10.dp)
        )
        Column {
            Text(
                text = "Mental Health app",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,)
            Text(
                text = "Tu bienestar mental🫶",
                fontSize = 10.sp
            )
        }
    }
}