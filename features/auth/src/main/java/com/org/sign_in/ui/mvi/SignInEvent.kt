package com.org.sign_in.ui.mvi

sealed interface SignInEvent {

    data object OnBackClicked : SignInEvent

    data class OnLoginValueChanged(val value: String) : SignInEvent

    data class OnPasswordValueChanged(val value: String) : SignInEvent

    data class OnPasswordEyeIconClicked(val isPasswordVisible: Boolean) : SignInEvent

    data class OnContinueClicked(val login: String, val password: String): SignInEvent

    data object OnForgotPasswordClicked : SignInEvent

    data object OnDismissSignInError : SignInEvent
}
