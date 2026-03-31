package com.org.common.validation

import javax.inject.Inject

// TODO: Use String resource instead hardcoded strings
class AuthValidator @Inject constructor() {

    fun validateEmailAndPassword(
        email: String,
        password: String
    ): ValidationResult {
        val errors = mutableListOf<AuthError>()

        if (!EMAIL_REGEX.matches(email)) {
            errors += AuthError.EmailError("Invalid email format")
        }

        if (password.length !in 4..32) {
            errors += AuthError.PasswordError(
                "Password must be between 6 and 32 characters"
            )
        }

        return if (errors.isEmpty()) {
            ValidationResult.Success
        } else {
            ValidationResult.Error(errors)
        }
    }

    private companion object {

        val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    }
}
