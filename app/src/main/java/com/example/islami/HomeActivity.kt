package com.example.islami

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.hadith.HadithFragment
import com.example.islami.quran.QuranFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {
                menuItem->
            if (menuItem.itemId == R.id.ic_quran_nav) {
                startFragment(QuranFragment())

            }
            else if (menuItem.itemId == R.id.ic_hadith_nav) {
                startFragment(HadithFragment())
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

