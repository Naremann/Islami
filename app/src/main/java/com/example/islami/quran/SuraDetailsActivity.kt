package com.example.islami.quran

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class SuraDetailsActivity : AppCompatActivity() {

    lateinit var suraNameBar : TextView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: quranDetailsAdapter
    lateinit var verse : MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        suraNameBar = findViewById(R.id.suraNameToolBar_tv)
        setSupportActionBar(findViewById(R.id.toolbar_hadith))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //supportActionBar?.setIcon(R.drawable.ic_back_arrow)
        initRecycler()
        val suraNameText = intent.getStringExtra(ConstantVaribles.suraNameText)
        val suraPosition : Int = intent.getIntExtra(ConstantVaribles.suraPosition , -1)
        suraNameBar.setText("سوره"+" "+suraNameText)
        readSuraDetails(suraPosition)



        }
    private fun initRecycler() {
        recyclerView = findViewById(R.id.suraDetails_recycler)
        adapter = quranDetailsAdapter()
        recyclerView.adapter = adapter

    }

    private fun readSuraDetails(suraPos: Int) {
        val fileName = "${suraPos+1}.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
        verse = fileContent.split("/n") as MutableList<String>
        adapter.updateData(verse)
    //verse.add("1")


    }


}