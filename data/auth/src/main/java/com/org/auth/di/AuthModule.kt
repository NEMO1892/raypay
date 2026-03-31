package com.org.auth.di

import com.org.auth.repository.AuthRepository
import com.org.auth.repository.SignInRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class AuthModule {

    @Binds
    @Singleton
    abstract fun bindSignInRepository(authRepository: AuthRepository): SignInRepository
}
