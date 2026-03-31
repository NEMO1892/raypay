package com.org.firebase.auth

interface FirebaseAuthManager {

    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<Unit>
}
