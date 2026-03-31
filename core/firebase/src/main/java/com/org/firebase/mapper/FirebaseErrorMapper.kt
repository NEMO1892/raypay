package com.org.firebase.mapper

import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.org.firebase.model.AuthError
import javax.inject.Inject

internal class FirebaseErrorMapper @Inject constructor() {

    operator fun invoke(unmapped: Throwable): AuthError = when (unmapped) {
        is FirebaseAuthWeakPasswordException -> AuthError.WeakPassword
        is FirebaseAuthInvalidCredentialsException -> AuthError.InvalidCredentials
        is FirebaseAuthUserCollisionException -> AuthError.UserAlreadyExists
        is FirebaseAuthInvalidUserException -> AuthError.InvalidUser
        else -> AuthError.Unknown
    }
}
