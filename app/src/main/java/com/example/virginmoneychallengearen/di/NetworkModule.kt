package com.example.virginmoneychallengearen.di

import com.example.virginmoneychallengearen.api.ApiDetails
import com.example.virginmoneychallengearen.api.ApiReference.BASE_URL
import com.example.virginmoneychallengearen.repository.Repository
import com.example.virginmoneychallengearen.repository.RepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun getGson():Gson = Gson()

    @Provides
    fun retrofitBuilder(gson: Gson) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun getApiDetails(retrofit: Retrofit): ApiDetails = retrofit.create(ApiDetails::class.java)

//    @Provides
//    fun getRepository():Repository = RepositoryImp(getApiDetails(retrofitBuilder(getGson())))
}