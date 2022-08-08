package com.example.virginmoneychallengearen.di

import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.repository.RepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getRepository(repository: RepositoryImp):Repository
}