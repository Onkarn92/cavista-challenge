package com.onkarnene.cavista.challenge.database

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {
	
	@TypeConverter
	fun toComments(value: String): ArrayList<String> = arrayListOf<String>().apply {
		try {
			val licences = Gson().fromJson(value, Array<String>::class.java).toList()
			addAll(licences)
		} catch (e: Exception) {
			e.printStackTrace()
		}
	}
	
	@TypeConverter
	fun fromComments(value: ArrayList<String>): String = Gson().toJson(value)
}