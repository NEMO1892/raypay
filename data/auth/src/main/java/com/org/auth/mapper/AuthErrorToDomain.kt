package com.org.auth.mapper

import com.org.auth.model.DomainAuthError
import com.org.firebase.model.AuthError
import com.org.firebase.utils.mapError

fun <T> Result<T>.mapAuthErrorToDomain(): Result<T> = mapError { throwable ->
    (throwable as? AuthError)?.toDomain() ?: DomainAuthError.Unknown(throwable)
}

fun AuthError.toDomain(): DomainAuthError = when (this) {
    AuthError.WeakPassword -> DomainAuthError.WeakPassword
    AuthError.InvalidCredentials -> DomainAuthError.InvalidCredentials
    AuthError.UserAlreadyExists -> DomainAuthError.UserAlreadyExists
    AuthError.InvalidUser -> DomainAuthError.InvalidUser
    is AuthError.Unknown -> DomainAuthError.Unknown(this.cause ?: Throwable("Unknown error"))
}
