package com.example.islami.repos.radio

import com.example.islami.database.MyDatabase
import com.example.islami.model.RadiosItem


class QuranAudioOfflineDAtaSourceImp(private val database: MyDatabase) : QuranAudioOfflineDAtaSource{
    override suspend fun updateAudioList(audioList: List<RadiosItem?>?) {
        database.userDao().updateAudioList(audioList)
    }

    override suspend fun getQuranAudio(): List<RadiosItem?>? {
        return database.userDao().getAudioList()
    }


}