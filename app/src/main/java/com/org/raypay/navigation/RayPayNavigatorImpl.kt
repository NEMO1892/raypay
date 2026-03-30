package com.org.raypay.navigation

import androidx.navigation.NavController
import com.org.navigation.RayPayDestination
import com.org.navigation.RayPayNavigator

class RayPayNavigatorImpl(
    private val navController: NavController
) : RayPayNavigator {

    override fun navigateBack() {
        navController.popBackStack()
    }

    override fun navigateToLogIn() {
        navController.navigate(RayPayDestination.LogIn.route)
    }
}