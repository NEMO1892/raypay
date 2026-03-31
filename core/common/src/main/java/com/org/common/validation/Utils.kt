package com.org.common.validation

fun List<AuthError>.emailMessage(): String? =
    filterIsInstance<AuthError.EmailError>().firstOrNull()?.message

fun List<AuthError>.passwordMessage(): String? =
    filterIsInstance<AuthError.PasswordError>().firstOrNull()?.message
