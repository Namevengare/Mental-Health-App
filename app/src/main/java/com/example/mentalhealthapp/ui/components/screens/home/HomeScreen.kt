package com.example.mentalhealthapp.ui.components.screens.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(){
    MentalHealthBanner()
    Spacer(Modifier.height(20.dp))
    HomeContent()
}
