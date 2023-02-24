package com.example.islami.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class QuranResponse(

	@field:SerializedName("radios")
	val radios: List<RadiosItem?>? = null
)

@Entity
data class RadiosItem(

	@ColumnInfo
	@field:SerializedName("name")
	val name: String? = null,

	@PrimaryKey
	@ColumnInfo
	@field:SerializedName("id")
	val id: Int? = null,

	@ColumnInfo
	@field:SerializedName("url")
	val url: String? = null
)
