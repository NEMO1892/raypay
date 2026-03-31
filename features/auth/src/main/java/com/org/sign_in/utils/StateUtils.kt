package com.org.sign_in.utils

import com.org.auth.model.DomainAuthError
import com.org.sign_in.ui.mvi.SignInState

fun SignInState.updateForAuthError(authError: DomainAuthError?): SignInState = when (authError) {
    is DomainAuthError.WeakPassword -> copy(
        isLoading = false,
        supportTextPassword = "Password is too weak",
    )

    is DomainAuthError.InvalidCredentials -> copy(
        isLoading = false,
        signInPopupErrorText = "Invalid email or password",
    )

    is DomainAuthError.UserAlreadyExists -> copy(
        isLoading = false,
        signInPopupErrorText = "User already exists",
    )

    is DomainAuthError.InvalidUser -> copy(
        isLoading = false,
        signInPopupErrorText = "Email does not exist or has been disabled",
    )

    is DomainAuthError.Unknown, null -> copy(
        isLoading = false,
        signInPopupErrorText = "Unknown error occurred",
    )
}
