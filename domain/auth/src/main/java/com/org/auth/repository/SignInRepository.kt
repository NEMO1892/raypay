package com.org.auth.repository

interface SignInRepository {

    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<Unit>
}
