package com.org.raypay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.org.navigation.RayPayDestination
import com.org.navigation.RayPayNavigator
import com.org.onboarding.ui.WelcomeScreen

@Composable
internal fun AppNavGraph(
    rayPayNavigator: RayPayNavigator,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = RayPayDestination.Welcome.route,
    ) {
        composable(RayPayDestination.Welcome.route) {
            WelcomeScreen(rayPayNavigator = rayPayNavigator)
        }

        composable(RayPayDestination.LogIn.route) {
            // TODO: set LogIn screen
        }
    }
}
