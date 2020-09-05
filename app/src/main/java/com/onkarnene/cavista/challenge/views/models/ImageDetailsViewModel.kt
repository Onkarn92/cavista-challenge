package com.onkarnene.cavista.challenge.views.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import com.onkarnene.cavista.challenge.views.ImageDetailsActivity

/**
 * ViewModel implementation for [ImageDetailsActivity]
 */
class ImageDetailsViewModel(
		val app: Application,
		private val repository: ImageRepository
) : AndroidViewModel(app) {
	
	/**
	 * @param id of the selected image to be search in local database.
	 */
	fun getImageById(id: String): LiveData<Image?> = repository.getImage(id)
	
	/**
	 * @param image object to be save in local database.
	 */
	fun saveImageWithComments(image: Image) = repository.saveImage(image)
}