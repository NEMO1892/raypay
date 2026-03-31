package com.org.firebase.model

sealed class AuthError : Throwable() {

    object WeakPassword : AuthError()
    object InvalidCredentials : AuthError()
    object UserAlreadyExists : AuthError()
    object InvalidUser : AuthError()
    object Unknown : AuthError()
}
