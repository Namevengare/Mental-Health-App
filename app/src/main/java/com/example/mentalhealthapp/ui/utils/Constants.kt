package com.example.mentalhealthapp.ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Info
import com.example.mentalhealthapp.ui.models.BottomNavItem

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Inicio",
            Icon = Icons.Filled.Home,
            route = "home"
        ),
        BottomNavItem(
            label = "Transtornos",
            Icon = Icons.Filled.List,
            route = "trastornos"
        ),
        BottomNavItem(
            label = "Citas",
            Icon = Icons.Filled.DateRange,
            route = "citas"
        ),
        BottomNavItem(
            label = "Noticias",
            Icon = Icons.Filled.Info,
            route = "noticias"
        )
    )
}
