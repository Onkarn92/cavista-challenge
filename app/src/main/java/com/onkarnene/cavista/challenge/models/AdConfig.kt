package com.onkarnene.cavista.challenge.models

import com.google.gson.annotations.SerializedName

data class AdConfig(
        @SerializedName("safeFlags") var safeFlags: List<String> = listOf(),
        @SerializedName("highRiskFlags") var highRiskFlags: List<Any> = listOf(),
        @SerializedName("unsafeFlags") var unsafeFlags: List<String> = listOf(),
        @SerializedName("wallUnsafeFlags") var wallUnsafeFlags: List<Any> = listOf(),
        @SerializedName("showsAds") var showsAds: Boolean = false
)