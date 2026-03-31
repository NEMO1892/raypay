package com.org.auth.use_case

import com.org.auth.repository.SignInRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val signInRepository: SignInRepository) {

    suspend operator fun invoke(email: String, password: String) =
        signInRepository.signInWithEmailAndPassword(email, password)
}
