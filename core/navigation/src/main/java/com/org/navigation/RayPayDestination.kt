package com.org.navigation

sealed class RayPayDestination(val route: String) {

    object Welcome : RayPayDestination("Welcome")

    object LogIn : RayPayDestination("LogIn")

    object Credentials : RayPayDestination("Credentials")
}
