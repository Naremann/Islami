package com.example.islami.hadith

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class hadithDetailsActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: hadithDetailsAdapter
    lateinit var verse : List<String>
    var list: MutableList<String> = mutableListOf()
    lateinit var hadithName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadith_details)
        hadithName = findViewById(R.id.hadith_num_ToolBar_tv)

        var hadithNameText = intent.getStringExtra(Constants.Hadith_NAME)
        var hadithPosition = intent.getIntExtra(Constants.HADITH_POSITION , -1)
        hadithName.setText(hadithNameText)
       initRecycler()
        readSuraDetails(hadithPosition)




    }
    private fun initRecycler() {

        recyclerView = findViewById(R.id.hadith_content_recycler)
        adapter = hadithDetailsAdapter()
        recyclerView.adapter = adapter

    }

   private fun readSuraDetails(position : Int) {
        val fileName = "hadith.txt"
        val fileContent = assets.open(fileName).bufferedReader().use { it.readText() }
       verse = fileContent.split("#")
       var hadithContent : String? = null
       hadithContent = verse.get(position)
       var updatedHadithContent : List<String> = mutableListOf(hadithContent)
           adapter.updateData(updatedHadithContent)
    }

}