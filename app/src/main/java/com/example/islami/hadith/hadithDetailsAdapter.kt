package com.example.islami.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class hadithDetailsAdapter() : RecyclerView.Adapter<hadithDetailsAdapter.hadithViewHolder>() {
   var listData : List<String>? = null


    class hadithViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var hadithContent : TextView = itemView.findViewById(R.id.hadithContentItem_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hadithViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hadith_content_item,parent,false)
        return hadithViewHolder(view)
    }

    override fun onBindViewHolder(holder: hadithViewHolder, position: Int) {
        val hadithContentItem : String? = listData?.get(position)
        holder.hadithContent.setText(hadithContentItem)

    }


    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }
    fun updateData(verse : List<String>){
        this.listData = verse
        notifyDataSetChanged()

    }

}