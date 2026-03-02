package com.example.mentalhealthapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun HomeContent(modifier: Modifier = Modifier){
    val icon = painterResource(com.example.mentalhealthapp.R.drawable.fruit_15467270)
    Card(modifier.fillMaxSize()) {
        Row() {         Image(
            painter = icon,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
        )
            Column() {
                Text(
                    text = "Bienvenido a MentalHealth",
                    fontSize = 20.sp
                )
                Text(
                    text = "Tu salud mental es importante. Aquí encontrarás información valiosa sobre diversos trastornos mentales y recursos para cuidar tu bienestar."
                )}
            }
    }
}