package com.onkarnene.cavista.challenge.models

import com.google.gson.annotations.SerializedName
import com.onkarnene.cavista.challenge.utilities.DEFAULT_INT
import com.onkarnene.cavista.challenge.utilities.DEFAULT_LONG
import com.onkarnene.cavista.challenge.utilities.EMPTY_STRING

data class Data(
		@SerializedName("id") var id: String? = EMPTY_STRING,
		@SerializedName("title") var title: String? = EMPTY_STRING,
		@SerializedName("description") var description: String? = EMPTY_STRING,
		@SerializedName("datetime") var datetime: Long = DEFAULT_LONG,
		@SerializedName("link") var link: String? = EMPTY_STRING,
		@SerializedName("comment_count") var commentCount: Int = DEFAULT_INT,
		@SerializedName("images") var images: List<Image> = listOf()
)