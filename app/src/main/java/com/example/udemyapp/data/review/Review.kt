package com.example.udemyapp.data.review

import com.example.udemyapp.data.user.User
import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("_class") val _class: String,
    @SerializedName("id") val id: Int,
    @SerializedName("content") val content: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("created") val created: String,
    @SerializedName("modified") val modified: String,
    @SerializedName("user_modified") val user_modified: String,
    @SerializedName("user") val user: User
)