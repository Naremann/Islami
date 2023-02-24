package com.example.islami.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class QuranAdapter(private var listData : List<String>) : RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {
    lateinit var onItemClick : OnClickItemListener


    class QuranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suratName : TextView = itemView.findViewById(R.id.suraName_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sura_name_item,parent,false)
        return QuranViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val suratNameItem : String = listData[position]
        holder.suratName.text = suratNameItem
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(position, suratNameItem )
        }

    }


    override fun getItemCount(): Int {
        return listData.size
    }
    interface OnClickItemListener{
        fun onItemClick(position : Int , item : String)
    }
}