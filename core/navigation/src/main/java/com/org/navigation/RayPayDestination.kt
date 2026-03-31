package com.org.navigation

sealed class RayPayDestination(val route: String) {

    object Welcome : RayPayDestination("Welcome")

    object LogIn : RayPayDestination("LogIn")

    object SignIn : RayPayDestination("SignIn")

    object SignUp : RayPayDestination("SignUp")

    object ForgotPassword : RayPayDestination("ForgotPassword")

    object Home : RayPayDestination("Home")
}
