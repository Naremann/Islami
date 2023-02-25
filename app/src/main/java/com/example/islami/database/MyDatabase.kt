package com.example.islami.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.islami.model.RadiosItem

@Database( entities = [RadiosItem::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun userDao(): QuranAudioDao
    companion object{
        private const val DATABASE_NAME = "database"
        private var database : MyDatabase?=null
        fun init(context: Context){
            if(database == null){
                database = Room.databaseBuilder(context,MyDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getInstance() : MyDatabase{
            return database!!
        }
    }
}