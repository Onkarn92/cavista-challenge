package com.onkarnene.cavista.challenge.repositories

import com.onkarnene.cavista.challenge.interfaces.APICallback
import com.onkarnene.cavista.challenge.interfaces.HttpEventTracker
import com.onkarnene.cavista.challenge.interfaces.HttpOperationCallback
import com.onkarnene.cavista.challenge.models.Data
import com.onkarnene.cavista.challenge.models.GallerySearchResponse
import com.onkarnene.cavista.challenge.networks.HttpOperationWrapper
import com.onkarnene.cavista.challenge.utilities.NetworkUtils
import okhttp3.ResponseBody
import retrofit2.Call

class ImageRepository(private val eventTracker: HttpEventTracker<List<Data>>) : HttpOperationCallback<GallerySearchResponse> {
	
	private val apiCallback: APICallback by lazy {NetworkUtils.retrofit.create(APICallback::class.java)}
	private val httpOperationWrapper by lazy {HttpOperationWrapper<GallerySearchResponse>()}
	
	override fun onResponse(
			call: Call<GallerySearchResponse>,
			result: GallerySearchResponse?,
			errorPair: Pair<String, Throwable>,
			errorBody: ResponseBody?
	) {
		when {
			result?.success == true && result.dataList.isNotEmpty() -> eventTracker.onCallSuccess(result.dataList)
			else -> eventTracker.onCallFail(errorPair.first, errorPair.second, errorBody)
		}
	}
	
	fun searchImage(
			page: Int,
			query: String
	) {
		httpOperationWrapper.initCall(apiCallback.searchGallery(page, query), this)
	}
}