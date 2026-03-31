package com.org.raypay.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.org.home.HomeScreen
import com.org.login.LoginScreen
import com.org.navigation.RayPayDestination
import com.org.navigation.RayPayNavigator
import com.org.onboarding.ui.WelcomeScreen
import com.org.sign_in.ui.SignInScreen

private const val TRANSITION_DURATION = 400

@Composable
internal fun AppNavGraph(
    rayPayNavigator: RayPayNavigator,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = RayPayDestination.Welcome.route,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(TRANSITION_DURATION)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(TRANSITION_DURATION)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(TRANSITION_DURATION)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(TRANSITION_DURATION)
            )
        },
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

        composable(RayPayDestination.SignUp.route) {
            // TODO: add navigation to SignUp screen
        }

        composable(RayPayDestination.Home.route) {
            HomeScreen(rayPayNavigator = rayPayNavigator)
        }
    }
}