package com.onkarnene.cavista.challenge

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class App : Application() {
	
	companion object {
		
		private lateinit var app: App
		
		/**
		 * @return current context of this application
		 */
		@JvmStatic
		fun getContext(): Context = app.applicationContext
		
		@JvmStatic
		fun getApplication(): App = app
	}
	
	override fun onCreate() {
		super.onCreate()
		app = this
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
	}
}