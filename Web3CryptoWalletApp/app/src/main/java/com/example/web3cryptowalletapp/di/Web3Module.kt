package com.example.web3cryptowalletapp.di

import android.app.Activity
import com.example.web3cryptowalletapp.data.web3.Web3Repository
import com.example.web3cryptowalletapp.data.web3.Web3RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Web3Module {

    @Provides
    @Singleton
    fun provideWeb3Repository(): Web3Repository {
        return Web3RepositoryImpl()
    }
}