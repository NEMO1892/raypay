package com.org.raypay.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.org.login.LoginScreen
import com.org.navigation.RayPayDestination
import com.org.navigation.RayPayNavigator
import com.org.onboarding.ui.WelcomeScreen
import com.org.sign_in.ui.SignInScreen

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
            LoginScreen(rayPayNavigator = rayPayNavigator)
        }

        composable(RayPayDestination.SignIn.route) {
            SignInScreen(rayPayNavigator = rayPayNavigator)
        }

        composable(RayPayDestination.ForgotPassword.route) {
            // TODO: add navigation to ForgotPassword screen
        }
    }
}
