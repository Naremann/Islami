package com.example.islami.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val BASE_URL = "https://mp3quran.net"

    @Provides
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }
    @Provides
    fun provideRetrofit(converterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .build()
    }

    @Provides
    fun provideWebService(retrofit: Retrofit):WebServices{
        return retrofit.create(WebServices::class.java)
    }
}