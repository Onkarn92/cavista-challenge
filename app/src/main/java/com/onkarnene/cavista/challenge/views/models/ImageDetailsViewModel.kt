package com.onkarnene.cavista.challenge.views.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.repositories.ImageRepository

class ImageDetailsViewModel(app: Application) : AndroidViewModel(app) {
	
	private val repository: ImageRepository by lazy {ImageRepository()}
	
	fun getImageById(id: String): LiveData<Image?> = repository.getImage(id)
	
	fun saveImageWithComments(image: Image) = repository.saveImage(image)
}