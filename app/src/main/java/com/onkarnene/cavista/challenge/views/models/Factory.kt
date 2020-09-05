package com.onkarnene.cavista.challenge.views.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onkarnene.cavista.challenge.App
import com.onkarnene.cavista.challenge.repositories.ImageRepository

/**
 * Custom ViewModel factory which provides current [App] context and [ImageRepository].
 */
class Factory(private val repository: ImageRepository) : ViewModelProvider.NewInstanceFactory() {
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return when {
			modelClass.isAssignableFrom(SearchActivityViewModel::class.java) -> {
				(SearchActivityViewModel(App.getApplication(), repository) as T)
			}
			modelClass.isAssignableFrom(ImageDetailsViewModel::class.java) -> {
				(ImageDetailsViewModel(App.getApplication(), repository) as T)
			}
			else -> {
				super.create(modelClass)
			}
		}
	}
}