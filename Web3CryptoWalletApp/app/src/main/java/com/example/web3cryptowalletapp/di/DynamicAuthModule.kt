package com.example.web3cryptowalletapp.di

import com.dynamic.sdk.android.DynamicSDK
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSource
import com.example.web3cryptowalletapp.data.auth.DynamicAuthDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Provider
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DynamicAuthModule {


    @Provides
    @Singleton
    fun provideAuthDataSource(): DynamicAuthDataSource {
        return DynamicAuthDataSourceImpl()
    }
}