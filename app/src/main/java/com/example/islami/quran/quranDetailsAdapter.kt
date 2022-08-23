package com.example.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class quranDetailsAdapter() : RecyclerView.Adapter<quranDetailsAdapter.quranViewHolder>() {
   var listData : List<String>? = null


    class quranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suraContent : TextView = itemView.findViewById(R.id.suraContentItem_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sura_content_item,parent,false)
        return quranViewHolder(view)
    }

    override fun onBindViewHolder(holder: quranViewHolder, position: Int) {
        val suraContentItem : String? = listData?.get(position)
        holder.suraContent.setText(suraContentItem)

    }


    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }
    fun updateData(verse : List<String>){
        this.listData = verse
        notifyDataSetChanged()

    }

}