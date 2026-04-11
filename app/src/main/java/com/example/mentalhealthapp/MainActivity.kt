package com.example.mentalhealthapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.mentalhealthapp.notifications.NotificationHelper
import com.example.mentalhealthapp.notifications.WebSocketManager
import com.example.mentalhealthapp.ui.components.screens.home.HomeScreen
import com.example.mentalhealthapp.ui.components.screens.disorders.DisorderScreen
import com.example.mentalhealthapp.ui.components.screens.disorders.DisorderDetailScreen
import com.example.mentalhealthapp.ui.components.screens.appointments.AppointmentsScreen
import com.example.mentalhealthapp.ui.models.disordersList
import com.example.mentalhealthapp.ui.theme.MentalHealthAppTheme
import com.example.mentalhealthapp.ui.utils.Constants

@Composable fun NoticiasScreen() { Text("Pantalla de Noticias") }

class MainActivity : ComponentActivity() {
    private lateinit var webSocketManager: WebSocketManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val notificationHelper = NotificationHelper(this)
        webSocketManager = WebSocketManager(notificationHelper)

        val socketUrl = "wss://sharpie-wind-lily.ngrok-free.dev/ws-notifications"
        webSocketManager.connect(socketUrl)

        enableEdgeToEdge()
        setContent {
            MentalHealthAppTheme {
                val context = LocalContext.current
                var hasNotificationPermission by remember {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        mutableStateOf(
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.POST_NOTIFICATIONS
                            ) == PackageManager.PERMISSION_GRANTED
                        )
                    } else {
                        mutableStateOf(true)
                    }
                }

                val permissionLauncher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = { isGranted ->
                        hasNotificationPermission = isGranted
                    }
                )

                LaunchedEffect(Unit) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        if (ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.POST_NOTIFICATIONS
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }
                    }
                }

                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }
                    ) { padding ->
                        NavHostContainer(navController = navController, padding = padding)
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::webSocketManager.isInitialized) {
            webSocketManager.disconnect()
        }
    }
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(padding)
    ) {
        composable("home") { HomeScreen() }
        
        composable("trastornos") { 
            DisorderScreen(onItemClick = { disorderId -> 
                navController.navigate("disorder_detail/$disorderId")
            }) 
        }
        
        composable(
            route = "disorder_detail/{disorderId}",
            arguments = listOf(navArgument("disorderId") { type = NavType.StringType })
        ) { backStackEntry ->
            val disorderId = backStackEntry.arguments?.getString("disorderId")
            val disorder = disordersList.find { it.id == disorderId }
            if (disorder != null) {
                DisorderDetailScreen(
                    disorder = disorder,
                    onBackToCitas = { navController.navigate("citas") }
                )
            }
        }

        composable("citas") { AppointmentsScreen() }
        composable("noticias") { NoticiasScreen() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    Column {
        HorizontalDivider(
            thickness = 0.5.dp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f)
        )
        NavigationBar(
            modifier = Modifier.height(64.dp),
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = 0.dp
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            Constants.BottomNavItems.forEach { navItem ->
                NavigationBarItem(
                    selected = currentRoute == navItem.route,
                    onClick = {
                        if (currentRoute != navItem.route) {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = navItem.Icon, 
                            contentDescription = navItem.label,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    },
                    label = null,
                    alwaysShowLabel = false,
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        indicatorColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f)
                    )
                )
            }
        }
    }
}
