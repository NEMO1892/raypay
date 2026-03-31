package com.org.firebase.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.org.firebase.mapper.FirebaseErrorMapper
import com.org.firebase.utils.awaitUnit
import com.org.firebase.utils.mapError
import javax.inject.Inject

internal class FirebaseAuthManagerImpl @Inject constructor(
    private val firebaseErrorMapper: FirebaseErrorMapper,
) : FirebaseAuthManager {

    private val auth: FirebaseAuth by lazy { Firebase.auth }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Result<Unit> = runCatching {
        auth.signInWithEmailAndPassword(email, password).awaitUnit()
    }.mapError { throwable -> firebaseErrorMapper(throwable) }
}
