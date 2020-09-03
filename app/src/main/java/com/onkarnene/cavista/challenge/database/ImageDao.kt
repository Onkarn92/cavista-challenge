package com.onkarnene.cavista.challenge.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.onkarnene.cavista.challenge.models.Image

@Dao
interface ImageDao {
	
	@Query("SELECT * FROM Image WHERE id = :id")
	fun getImage(id: String): LiveData<Image?>
	
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun saveOrUpdateImage(image: Image)
}