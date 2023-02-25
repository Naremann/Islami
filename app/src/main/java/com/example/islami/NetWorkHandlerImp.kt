package com.example.islami

import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetWorkHandlerImp : NetworkHandler {
    override fun isOnline(): Boolean {
        return isNetworkAvailable()
    }

    private fun isNetworkAvailable() : Boolean {
        var connected = false
        val connectivityManager = Constants.CONNECTIVITY_MANAGER
        if(connectivityManager!!.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!.state == NetworkInfo.State.CONNECTED ||
            connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED)
            connected = true
        return connected
    }

}