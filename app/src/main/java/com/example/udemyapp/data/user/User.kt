package com.example.udemyapp.data.user

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_class") val _class: String,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("name") val name: String,
    @SerializedName("display_name") val display_name: String
)