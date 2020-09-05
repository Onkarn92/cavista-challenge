package com.onkarnene.cavista.challenge.views.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.onkarnene.cavista.challenge.interfaces.HttpEventTracker
import com.onkarnene.cavista.challenge.models.Data
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import com.onkarnene.cavista.challenge.views.SearchActivity
import okhttp3.ResponseBody

/**
 * ViewModel implementation for [SearchActivity]
 */
class SearchActivityViewModel(
		val app: Application,
		private val repository: ImageRepository
) : AndroidViewModel(app), HttpEventTracker<List<Data>> {
	
	private val imageObservable: MutableLiveData<ArrayList<Image>> = MutableLiveData()
	private val errorObservable: MutableLiveData<Pair<String, Throwable>> = MutableLiveData()
	
	override fun onCallSuccess(response: List<Data>) {
		val images: ArrayList<Image> = arrayListOf()
		response.forEach {images.addAll(it.images)}
		imageObservable.postValue(images)
	}
	
	override fun onCallFail(
			cause: String,
			throwable: Throwable,
			responseBody: ResponseBody?
	) {
		errorObservable.postValue(cause to throwable)
	}
	
	/**
	 * Holds latest data of all images.
	 */
	fun getImageObservable() = imageObservable
	
	/**
	 * Holds any error response.
	 */
	fun getErrorObservable() = errorObservable
	
	/**
	 * Dispatch the inputted query and current page number to gallery search API.
	 */
	fun dispatchQueryText(
			page: Int = 1,
			query: String
	) {
		repository.searchImage(page, query, this)
	}
}