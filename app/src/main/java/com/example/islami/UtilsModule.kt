package com.example.islami

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    fun provideNetWorkHandler():NetworkHandler{
        return NetWorkHandlerImp()
    }
}