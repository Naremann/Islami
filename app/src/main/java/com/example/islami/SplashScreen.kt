package com.example.islami

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        android.os.Handler(Looper.getMainLooper()).postDelayed(object : Runnable{
            override fun run() {
                startHomeActivity()

            }

        },2000)
    }

    private fun startHomeActivity() {
        var intent = Intent(this , HomeActivity :: class.java)
        startActivity(intent)
        finish()
    }

}



