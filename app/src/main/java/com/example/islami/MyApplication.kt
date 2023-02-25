package com.example.islami

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.islami.database.MyDatabase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        Constants.CONNECTIVITY_MANAGER=connectivityManager
       /* Constants.NETWORK_HANDLER = object : NetworkHandler {
            override fun isOnline(): Boolean {
                return isNetworkAvailable()
            }
        }*/


    }


}