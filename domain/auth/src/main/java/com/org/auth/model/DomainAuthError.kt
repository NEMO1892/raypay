package com.org.auth.model

sealed class DomainAuthError : Throwable() {

    object WeakPassword : DomainAuthError()

    object InvalidCredentials : DomainAuthError()

    object UserAlreadyExists : DomainAuthError()

    object InvalidUser : DomainAuthError()

    data class Unknown(override val cause: Throwable) : DomainAuthError()
}
