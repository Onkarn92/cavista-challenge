package com.onkarnene.cavista.challenge.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.onkarnene.cavista.challenge.utilities.DEFAULT_LONG
import com.onkarnene.cavista.challenge.utilities.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Image(
		@PrimaryKey @SerializedName("id") var id: String = EMPTY_STRING,
		@SerializedName("title") var title: String? = EMPTY_STRING,
		@SerializedName("description") var description: String? = EMPTY_STRING,
		@SerializedName("datetime") var datetime: Long = DEFAULT_LONG,
		@SerializedName("type") var type: String? = EMPTY_STRING,
		@SerializedName("link") var link: String? = EMPTY_STRING,
		var comments: ArrayList<String> = arrayListOf()
) : Parcelable