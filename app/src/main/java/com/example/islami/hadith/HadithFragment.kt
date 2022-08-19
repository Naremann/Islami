package com.example.islami.hadith

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.quran.QuranAdapter

class HadithFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: HadithAdapter
    lateinit var list: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadith, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createData()
        recyclerView = view.findViewById(R.id.recycler_hadith)
        adapter = HadithAdapter(list)
        recyclerView.adapter = adapter
    }

    private fun createData() {
        list = mutableListOf()

        for (i : Int in 0..40 step 1){
            list.add("الحديث رقم $i")


        }
    }
}