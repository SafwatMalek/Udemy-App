package com.example.udemyapp.data.course

import com.google.gson.annotations.SerializedName


data class Options(
    @SerializedName("key") val key: String,
    @SerializedName("title") val title: String,
    @SerializedName("count") val count: Int,
    @SerializedName("value") val value: String
)