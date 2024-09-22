package com.task.tourismsmart.doman

import com.google.gson.annotations.SerializedName

data class Hotel(
    val city :String,
    val image1: String,
    val image2: String,
    val image3: String,
    val name: String,
    val totalScore: String,
    @SerializedName("url_google_map")
    val urlGoogleMap: String,
    val website: String

)
