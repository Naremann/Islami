package com.example.islami.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadithAdapter(var listData : List<String>) : RecyclerView.Adapter<HadithAdapter.HadithViewHolder>() {


    class HadithViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var hadithNum : TextView = itemView.findViewById(R.id.hadithNum_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.hadith_item,parent,false)
        return HadithViewHolder(view)
    }

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
        holder.hadithNum.setText(listData.get(position))
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}