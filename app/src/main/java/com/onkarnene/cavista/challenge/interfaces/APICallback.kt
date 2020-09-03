package com.onkarnene.cavista.challenge.interfaces

import com.onkarnene.cavista.challenge.models.GallerySearchResponse
import com.onkarnene.cavista.challenge.utilities.NetworkUtils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APICallback {
	
	@GET(NetworkUtils.ENDPOINT_SEARCH)
	fun searchGallery(
			@Path("page") page: Int = 1,
			@Query("q") query: String
	): Call<GallerySearchResponse>
}