package com.example.islami.repos.radio

import com.example.islami.NetworkHandler
import com.example.islami.api.WebServices
import com.example.islami.database.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RadioModule {
    @Provides
    fun provideAudioOnlineSource(webServices: WebServices):QuranAudioOnlineDAtaSource{
        return QuranAudioOnlineDAtaSourceImp(webServices)
    }

    @Provides
    fun provideAudioOfflineSource(database: MyDatabase):QuranAudioOfflineDAtaSource{
        return QuranAudioOfflineDAtaSourceImp(database)
    }

    @Provides
    fun provideAudioSource(quranAudioOfflineDAtaSource: QuranAudioOfflineDAtaSource,quranAudioOnlineDAtaSource: QuranAudioOnlineDAtaSource,networkHandler: NetworkHandler):QuranAudioRepository{
        return QuranAudioRepositoryImp(quranAudioOnlineDAtaSource,quranAudioOfflineDAtaSource,networkHandler)
    }

}