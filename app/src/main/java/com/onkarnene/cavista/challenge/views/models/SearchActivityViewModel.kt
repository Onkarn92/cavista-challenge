package com.onkarnene.cavista.challenge.views.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.onkarnene.cavista.challenge.interfaces.HttpEventTracker
import com.onkarnene.cavista.challenge.models.Data
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.repositories.ImageRepository
import okhttp3.ResponseBody

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
	
	fun getImageObservable() = imageObservable
	
	fun getErrorObservable() = errorObservable
	
	fun dispatchQueryText(
			page: Int = 1,
			query: String
	) {
		repository.searchImage(page, query, this)
	}
}