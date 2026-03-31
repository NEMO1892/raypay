package com.org.common.validation

sealed class ValidationResult {

    object Success : ValidationResult()
    data class Error(val errors: List<AuthError>) : ValidationResult()
}
