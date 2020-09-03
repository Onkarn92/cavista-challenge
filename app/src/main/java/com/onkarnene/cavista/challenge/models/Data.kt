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
		@SerializedName("cover") var cover: String? = EMPTY_STRING,
		@SerializedName("cover_width") var coverWidth: Int = DEFAULT_INT,
		@SerializedName("cover_height") var coverHeight: Int = DEFAULT_INT,
		@SerializedName("account_url") var accountUrl: String? = EMPTY_STRING,
		@SerializedName("account_id") var accountId: Long = DEFAULT_LONG,
		@SerializedName("privacy") var privacy: String? = EMPTY_STRING,
		@SerializedName("layout") var layout: String? = EMPTY_STRING,
		@SerializedName("views") var views: Int = DEFAULT_INT,
		@SerializedName("link") var link: String? = EMPTY_STRING,
		@SerializedName("ups") var ups: Int = DEFAULT_INT,
		@SerializedName("downs") var downs: Int = DEFAULT_INT,
		@SerializedName("points") var points: Int = DEFAULT_INT,
		@SerializedName("score") var score: Int = DEFAULT_INT,
		@SerializedName("is_album") var isAlbum: Boolean = false,
		@SerializedName("vote") var vote: Any? = Any(),
		@SerializedName("favorite") var favorite: Boolean = false,
		@SerializedName("nsfw") var nsfw: Boolean = false,
		@SerializedName("section") var section: String? = EMPTY_STRING,
		@SerializedName("comment_count") var commentCount: Int = DEFAULT_INT,
		@SerializedName("favorite_count") var favoriteCount: Int = DEFAULT_INT,
		@SerializedName("topic") var topic: String? = EMPTY_STRING,
		@SerializedName("topic_id") var topicId: Int = DEFAULT_INT,
		@SerializedName("images_count") var imagesCount: Int = DEFAULT_INT,
		@SerializedName("in_gallery") var inGallery: Boolean = false,
		@SerializedName("is_ad") var isAd: Boolean = false,
		@SerializedName("tags") var tags: List<Tag> = listOf(),
		@SerializedName("ad_type") var adType: Int = DEFAULT_INT,
		@SerializedName("ad_url") var adUrl: String? = EMPTY_STRING,
		@SerializedName("in_most_viral") var inMostViral: Boolean = false,
		@SerializedName("include_album_ads") var includeAlbumAds: Boolean = false,
		@SerializedName("images") var images: List<Image> = listOf(),
		@SerializedName("ad_config") var adConfig: AdConfig = AdConfig()
)