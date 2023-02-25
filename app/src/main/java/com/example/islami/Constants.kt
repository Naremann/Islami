package com.example.islami

import android.net.ConnectivityManager

object Constants {
    lateinit var NETWORK_HANDLER : NetworkHandler
    var iS_PLAY : Boolean = true
    var iS_PAUSE : Boolean = false
    var iS_VIEW_READER_NAME : Boolean = false
    var AUDIO_INDEX = 0
    var READER_NAME :String?=null
    var SURAT_TEXT = "سورة"
    var CONNECTIVITY_MANAGER:ConnectivityManager?=null
}