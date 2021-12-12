package com.example.udemyapp.data.course

import com.google.gson.annotations.SerializedName

data class VisibleInstructors(
    @SerializedName("_class") val _class: String,
    @SerializedName("title") val title: String,
    @SerializedName("name") val name: String,
    @SerializedName("display_name") val display_name: String,
    @SerializedName("job_title") val job_title: String,
    @SerializedName("image_50x50") val image_50x50: String,
    @SerializedName("image_100x100") val image_100x100: String,
    @SerializedName("initials") val initials: String,
    @SerializedName("url") val url: String
)