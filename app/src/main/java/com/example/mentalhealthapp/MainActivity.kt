package com.example.mentalhealthapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mentalhealthapp.ui.home.HomeScreen
import com.example.mentalhealthapp.ui.theme.MentalHealthAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MentalHealthAppTheme {
                Scaffold{interpadding ->
                    Column(modifier = Modifier.padding(interpadding)) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}