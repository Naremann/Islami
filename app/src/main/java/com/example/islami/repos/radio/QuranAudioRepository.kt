package com.example.islami.repos.radio

import android.content.Context
import com.example.islami.model.QuranResponse
import com.example.islami.model.RadiosItem
import java.io.File

interface QuranAudioRepository {
    suspend fun getQuranAudio():List<RadiosItem?>?
}
interface QuranAudioOnlineDAtaSource{
    suspend fun getQuranAudio():List<RadiosItem?>?
}
interface QuranAudioOfflineDAtaSource{
    suspend fun updateAudioList(audioList:List<RadiosItem?>?)
    suspend fun getQuranAudio():List<RadiosItem?>?
}

