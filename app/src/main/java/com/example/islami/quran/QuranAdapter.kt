package com.example.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import java.util.zip.Inflater

class QuranAdapter(var listData : List<String>) : RecyclerView.Adapter<QuranAdapter.quranViewHolder>() {


    class quranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suraName : TextView = itemView.findViewById(R.id.suraName_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quranViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.sura_name_item,parent,false)
        return quranViewHolder(view)
    }

    override fun onBindViewHolder(holder: quranViewHolder, position: Int) {
        holder.suraName.setText(listData.get(position))
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}