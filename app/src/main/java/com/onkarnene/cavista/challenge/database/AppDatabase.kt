package com.onkarnene.cavista.challenge.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.onkarnene.cavista.challenge.App
import com.onkarnene.cavista.challenge.models.Image

/**
 * Room persistence database for cavista app.
 */
@Database(entities = [Image::class], version = 1, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class AppDatabase : RoomDatabase() {
	
	companion object {
		
		private const val NAME = "cavista_challenge_db"
		private val lock = Any()
		@Volatile private var appDatabase: AppDatabase? = null
		
		/**
		 * Provide and maintain single instance.
		 */
		fun getInstance(): AppDatabase = appDatabase ?: synchronized(lock) {
			appDatabase ?: buildDatabase().also {appDatabase = it}
		}
		
		private fun buildDatabase(): AppDatabase = Room.databaseBuilder(App.getContext(), AppDatabase::class.java, NAME).apply {
			fallbackToDestructiveMigration()
		}.build()
	}
	
	/**
	 * Data access object for image entity.
	 */
	abstract fun imageDao(): ImageDao
}