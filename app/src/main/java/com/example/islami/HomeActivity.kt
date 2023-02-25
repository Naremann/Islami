package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.hadith.HadithFragment
import com.example.islami.quran.QuranFragment
import com.example.islami.radio.RadioFragment
import com.example.islami.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
                menuItem->
            when (menuItem.itemId) {
                R.id.ic_quran_nav -> {
                    startFragment(QuranFragment())

                }
                R.id.ic_hadith_nav -> {
                    startFragment(HadithFragment())
                }
                R.id.ic_sebha_nav -> {
                    startFragment(SebhaFragment())
                }
                R.id.ic_radio_nav -> {
                    startFragment(RadioFragment())
                }
            }
            return@OnItemSelectedListener true
        })
        bottomNavigationView.selectedItemId = R.id.ic_quran_nav





    }

    private fun startFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_container, fragment).commit()
    }
}

