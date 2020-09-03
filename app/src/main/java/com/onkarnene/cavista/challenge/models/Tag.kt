package com.onkarnene.cavista.challenge.models

import com.google.gson.annotations.SerializedName
import com.onkarnene.cavista.challenge.utilities.DEFAULT_INT
import com.onkarnene.cavista.challenge.utilities.EMPTY_STRING

data class Tag(
		@SerializedName("name") var name: String? = EMPTY_STRING,
		@SerializedName("display_name") var displayName: String? = EMPTY_STRING,
		@SerializedName("followers") var followers: Int = DEFAULT_INT,
		@SerializedName("total_items") var totalItems: Int = DEFAULT_INT,
		@SerializedName("following") var following: Boolean = false,
		@SerializedName("is_whitelisted") var isWhitelisted: Boolean = false,
		@SerializedName("background_hash") var backgroundHash: String? = EMPTY_STRING,
		@SerializedName("thumbnail_hash") var thumbnailHash: String? = EMPTY_STRING,
		@SerializedName("accent") var accent: String? = EMPTY_STRING,
		@SerializedName("background_is_animated") var backgroundIsAnimated: Boolean = false,
		@SerializedName("thumbnail_is_animated") var thumbnailIsAnimated: Boolean = false,
		@SerializedName("is_promoted") var isPromoted: Boolean = false,
		@SerializedName("description") var description: String? = EMPTY_STRING,
		@SerializedName("logo_hash") var logoHash: String? = EMPTY_STRING,
		@SerializedName("logo_destination_url") var logoDestinationUrl: String? = EMPTY_STRING,
		@SerializedName("description_annotations") var descriptionAnnotations: Any = Any()
)