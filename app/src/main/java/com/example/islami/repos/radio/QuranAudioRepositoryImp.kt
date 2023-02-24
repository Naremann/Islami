package com.example.islami.repos.radio

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import com.example.islami.Constants
import com.example.islami.NetworkHandler
import com.example.islami.model.RadiosItem
import java.io.File
import java.io.InputStream

class QuranAudioRepositoryImp(
    private val quranAudioOnlineDAtaSource: QuranAudioOnlineDAtaSource,
    private val quranAudioOfflineDAtaSource: QuranAudioOfflineDAtaSource,
    private val networkHandler: NetworkHandler
) : QuranAudioRepository {
    override suspend fun getQuranAudio():List<RadiosItem?>? {

        try {
            if (networkHandler.isOnline()) {
                val audioList = quranAudioOnlineDAtaSource.getQuranAudio()
                quranAudioOfflineDAtaSource.updateAudioList(audioList)
                Log.e("getQuranAudio()","list${quranAudioOfflineDAtaSource.getQuranAudio()}")
                return  audioList
            }
            return quranAudioOfflineDAtaSource.getQuranAudio()
        } catch (ex: Exception) {
            return quranAudioOfflineDAtaSource.getQuranAudio()
        }
    }
}
