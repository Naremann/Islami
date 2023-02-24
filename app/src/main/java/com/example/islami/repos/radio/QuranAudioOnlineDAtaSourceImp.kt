package com.example.islami.repos.radio

import com.example.islami.Constants
import com.example.islami.api.WebServices
import com.example.islami.model.RadiosItem

class QuranAudioOnlineDAtaSourceImp(private val webServices: WebServices) :
    QuranAudioOnlineDAtaSource {
    override suspend fun getQuranAudio(): List<RadiosItem?>? {
        try {
            var audioList = webServices.getQuranAudio().radios
            return audioList
        }
        catch (ex:Exception){
            throw ex
        }
    }
}