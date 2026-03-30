package com.org.raypay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.org.design_system.theme.RaypayTheme
import com.org.raypay.navigation.AppNavGraph
import com.org.raypay.navigation.RayPayNavigatorImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RaypayTheme {
                val navController = rememberNavController()
                val rayPayNavigator = remember(navController) { RayPayNavigatorImpl(navController) }

                AppNavGraph(
                    rayPayNavigator = rayPayNavigator,
                    navController = navController,
                )
            }
        }
    }
}
