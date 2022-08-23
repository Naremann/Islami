package com.example.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import java.util.zip.Inflater

class QuranAdapter(var listData : List<String>) : RecyclerView.Adapter<QuranAdapter.quranViewHolder>() {
    lateinit var onItemClick : OnClickItemListener


    class quranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suraName : TextView = itemView.findViewById(R.id.suraName_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quranViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.sura_name_item,parent,false)
        return quranViewHolder(view)
    }

    override fun onBindViewHolder(holder: quranViewHolder, position: Int) {
        var suraNameItem : String = listData.get(position)
        holder.suraName.setText(suraNameItem)
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(position, suraNameItem )
        }

    }


    override fun getItemCount(): Int {
        return listData.size
    }
    interface OnClickItemListener{
        fun onItemClick(position : Int , item : String)
    }
}