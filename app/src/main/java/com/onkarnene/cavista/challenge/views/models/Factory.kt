package com.onkarnene.cavista.challenge.views.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.onkarnene.cavista.challenge.App

class Factory : ViewModelProvider.NewInstanceFactory() {
	
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T {
		return if (modelClass.isAssignableFrom(SearchActivityViewModel::class.java)) {
			(SearchActivityViewModel(App.getApplication()) as T)
		} else if (modelClass.isAssignableFrom(ImageDetailsViewModel::class.java)) {
			(ImageDetailsViewModel(App.getApplication()) as T)
		} else {
			super.create(modelClass)
		}
	}
}