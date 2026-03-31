package com.org.auth.repository

import com.org.auth.mapper.mapAuthErrorToDomain
import com.org.firebase.auth.FirebaseAuthManager
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuthManager: FirebaseAuthManager
) : SignInRepository {

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Unit> = firebaseAuthManager
        .signInWithEmailAndPassword(email, password)
        .mapAuthErrorToDomain()
}
