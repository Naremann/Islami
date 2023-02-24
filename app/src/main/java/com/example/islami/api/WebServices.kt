package com.example.islami.api

import com.example.islami.model.QuranResponse
import retrofit2.http.GET

interface WebServices {
    @GET("/api/v3/radios")
    suspend fun getQuranAudio() : QuranResponse
}