package com.axel.thesportsdb.di

import com.axel.thesportsdb.BuildConfig
import com.axel.thesportsdb.network.TheSportDbService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TheSportDbModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance() : TheSportDbService =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheSportDbService::class.java)



}