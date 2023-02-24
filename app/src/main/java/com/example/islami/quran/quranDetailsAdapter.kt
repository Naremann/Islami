package com.example.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class QuranDetailsAdapter: RecyclerView.Adapter<QuranDetailsAdapter.QuranViewHolder>() {
   private var listData : List<String>? = null


    class QuranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suratContent : TextView = itemView.findViewById(R.id.suraContentItem_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sura_content_item,parent,false)
        return QuranViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val suratContentItem : String? = listData?.get(position)
        holder.suratContent.text = suratContentItem

    }


    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }
    fun updateData(verse : List<String>){
        this.listData = verse
        notifyDataSetChanged()

    }

}