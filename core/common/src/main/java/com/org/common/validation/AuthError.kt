package com.org.common.validation

sealed class AuthError {

    data class EmailError(val message: String) : AuthError()
    data class PasswordError(val message: String) : AuthError()
}
