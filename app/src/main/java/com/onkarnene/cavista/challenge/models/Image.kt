package com.onkarnene.cavista.challenge.models

import com.google.gson.annotations.SerializedName
import com.onkarnene.cavista.challenge.utilities.DEFAULT_INT
import com.onkarnene.cavista.challenge.utilities.DEFAULT_LONG
import com.onkarnene.cavista.challenge.utilities.EMPTY_STRING

data class Image(
        @SerializedName("id") var id: String? = EMPTY_STRING,
        @SerializedName("title") var title: String? = EMPTY_STRING,
        @SerializedName("description") var description: String? = EMPTY_STRING,
        @SerializedName("datetime") var datetime: Long = DEFAULT_LONG,
        @SerializedName("type") var type: String? = EMPTY_STRING,
        @SerializedName("animated") var animated: Boolean = false,
        @SerializedName("width") var width: Int = DEFAULT_INT,
        @SerializedName("height") var height: Int = DEFAULT_INT,
        @SerializedName("size") var size: Int = DEFAULT_INT,
        @SerializedName("views") var views: Int = DEFAULT_INT,
        @SerializedName("bandwidth") var bandwidth: Int = DEFAULT_INT,
        @SerializedName("vote") var vote: Any? = Any(),
        @SerializedName("favorite") var favorite: Boolean = false,
        @SerializedName("nsfw") var nsfw: Any? = Any(),
        @SerializedName("section") var section: Any? = Any(),
        @SerializedName("account_url") var accountUrl: String? = EMPTY_STRING,
        @SerializedName("account_id") var accountId: String? = EMPTY_STRING,
        @SerializedName("is_ad") var isAd: Boolean = false,
        @SerializedName("in_most_viral") var inMostViral: Boolean = false,
        @SerializedName("has_sound") var hasSound: Boolean = false,
        @SerializedName("tags") var tags: List<Tag> = listOf(),
        @SerializedName("ad_type") var adType: Int = DEFAULT_INT,
        @SerializedName("ad_url") var adUrl: String? = EMPTY_STRING,
        @SerializedName("edited") var edited: String? = EMPTY_STRING,
        @SerializedName("in_gallery") var inGallery: Boolean = false,
        @SerializedName("link") var link: String? = EMPTY_STRING,
        @SerializedName("comment_count") var commentCount: Any? = Any(),
        @SerializedName("favorite_count") var favoriteCount: Any? = Any(),
        @SerializedName("ups") var ups: Any? = Any(),
        @SerializedName("downs") var downs: Any? = Any(),
        @SerializedName("points") var points: Any? = Any(),
        @SerializedName("score") var score: Any? = Any()
)