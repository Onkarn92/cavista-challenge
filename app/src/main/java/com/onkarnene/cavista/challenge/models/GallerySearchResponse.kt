package com.onkarnene.cavista.challenge.models

import com.google.gson.annotations.SerializedName
import com.onkarnene.cavista.challenge.utilities.DEFAULT_INT

data class GallerySearchResponse(
		@SerializedName("data") var dataList: List<Data> = listOf(),
		@SerializedName("success") var success: Boolean = false,
		@SerializedName("status") var status: Int = DEFAULT_INT
)