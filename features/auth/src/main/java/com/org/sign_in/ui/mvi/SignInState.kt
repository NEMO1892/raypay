package com.org.sign_in.ui.mvi

import androidx.compose.runtime.Immutable

@Immutable
data class SignInState (
    val isLoading: Boolean = false,
    val isSignInButtonEnabled: Boolean = false,

    /**
     * Block of states for Password InputField
     * */
    val password: String = "",
    val supportTextPassword: String? = null,
    val isPasswordVisible: Boolean = false,

    /**
     * Block of states for Username/Email InputField
     * */
    val login: String = "",
    val supportTextLogin: String? = null,

    /**
     * Block of states for popup error
     */
    val signInPopupErrorText: String? = null,
)

internal fun SignInState.isErrorPassword() = supportTextPassword != null

internal fun SignInState.isErrorLogin() = supportTextLogin != null

internal fun SignInState.isShowSignInError() = signInPopupErrorText != null
