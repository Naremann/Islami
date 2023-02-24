package com.example.islami

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.islami.database.MyDatabase

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        MyDatabase.init(this)
        Constants.NETWORK_HANDLER = object : NetworkHandler {
            override fun isOnline(): Boolean {
                return isNetworkAvailable()
            }
        }


    }
    private fun isNetworkAvailable() : Boolean {
        var connected = false
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED)
            connected = true
        return connected
    }
    /*private fun isInternetConnection(): Boolean {
        val connectivityManager =
            getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting
    }*/



}