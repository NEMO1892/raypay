package com.org.firebase.di

import com.org.firebase.auth.FirebaseAuthManager
import com.org.firebase.auth.FirebaseAuthManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class FirebaseModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseAuthManager(firebaseAuthManagerImpl: FirebaseAuthManagerImpl): FirebaseAuthManager
}
