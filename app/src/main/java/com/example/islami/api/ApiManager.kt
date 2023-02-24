package com.example.islami.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {
    companion object{
        private var retrofit: Retrofit? = null
        //const val BASE_URL = "http://api.alquran.cloud"
        private const val BASE_URL = "https://mp3quran.net"
        fun getInstance() :Retrofit{
            if(retrofit == null){
                retrofit = Retrofit.Builder().
                baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
        fun getApis() : WebServices{
            return getInstance().create(WebServices::class.java)
        }
    }
}