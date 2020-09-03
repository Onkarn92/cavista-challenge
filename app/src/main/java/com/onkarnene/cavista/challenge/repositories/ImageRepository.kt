package com.onkarnene.cavista.challenge.repositories

import androidx.lifecycle.LiveData
import com.onkarnene.cavista.challenge.database.AppDatabase
import com.onkarnene.cavista.challenge.helpers.AppExecutors
import com.onkarnene.cavista.challenge.interfaces.APICallback
import com.onkarnene.cavista.challenge.interfaces.HttpEventTracker
import com.onkarnene.cavista.challenge.interfaces.HttpOperationCallback
import com.onkarnene.cavista.challenge.models.Data
import com.onkarnene.cavista.challenge.models.GallerySearchResponse
import com.onkarnene.cavista.challenge.models.Image
import com.onkarnene.cavista.challenge.networks.HttpOperationWrapper
import com.onkarnene.cavista.challenge.utilities.NetworkUtils
import okhttp3.ResponseBody
import retrofit2.Call

class ImageRepository : HttpOperationCallback<GallerySearchResponse> {
	
	private val apiCallback: APICallback by lazy {NetworkUtils.retrofit.create(APICallback::class.java)}
	private val httpOperationWrapper by lazy {HttpOperationWrapper<GallerySearchResponse>()}
	private var eventTracker: HttpEventTracker<List<Data>>? = null
	
	override fun onResponse(
			call: Call<GallerySearchResponse>,
			result: GallerySearchResponse?,
			errorPair: Pair<String, Throwable>,
			errorBody: ResponseBody?
	) {
		when {
			result?.success == true && result.dataList.isNotEmpty() -> eventTracker?.onCallSuccess(result.dataList)
			else -> eventTracker?.onCallFail(errorPair.first, errorPair.second, errorBody)
		}
	}
	
	fun searchImage(
			page: Int,
			query: String,
			callback: HttpEventTracker<List<Data>>
	) {
		eventTracker = callback
		httpOperationWrapper.initCall(apiCallback.searchGallery(page, query), this)
	}
	
	fun getImage(id: String): LiveData<Image?> = AppDatabase.getInstance().imageDao().getImage(id)
	
	fun saveImage(image: Image) {
		AppExecutors.diskIO.execute {
			AppDatabase.getInstance().imageDao().saveOrUpdateImage(image)
		}
	}
}