package com.example.islami.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.Constants
import com.example.islami.R

class SuratDetailsActivity : AppCompatActivity() {

    private lateinit var suratNameBar : TextView
    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: QuranDetailsAdapter
    private lateinit var verse : MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suratNameBar = findViewById(R.id.suraNameToolBar_tv)
        setSupportActionBar(findViewById(R.id.toolbar_hadith))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //supportActionBar?.setIcon(R.drawable.ic_back_arrow)
        initRecycler()
        val suratNameText = intent.getStringExtra(ConstantVaribles.SURAT_NAME_Text)
        val suratPosition : Int = intent.getIntExtra(ConstantVaribles.SURAT_POSITION , -1)
        suratNameBar.text = Constants.SURAT_TEXT+" "+suratNameText
        readSuratDetails(suratPosition)



        }
    private fun initRecycler() {
        recyclerView = findViewById(R.id.suraDetails_recycler)
        adapter = QuranDetailsAdapter()
        recyclerView.adapter = adapter

    }

    private fun readSuratDetails(suratPos: Int) {
        val fileName = "${suratPos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        verse = fileContent.split("/n") as MutableList<String>
        adapter.updateData(verse)
    }


}