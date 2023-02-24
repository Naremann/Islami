package com.example.islami.database

import androidx.room.*
import com.example.islami.model.RadiosItem

@Dao
interface QuranAudioDao {

    @Insert
    suspend fun updateAudioList(radioItem:List<RadiosItem?>?)

    @Query("SELECT * FROM RadiosItem")
     fun getAudioList() : List<RadiosItem>


}