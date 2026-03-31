package com.org.sign_in.ui.mvi

sealed interface SignInEffect {

    data object NavigateBack : SignInEffect

    data object NavigateToForgotPassword : SignInEffect

    data object NavigateToHome : SignInEffect
}
