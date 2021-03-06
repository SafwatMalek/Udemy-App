package com.example.udemyapp.data.course

import com.google.gson.annotations.SerializedName


data class CoursesResponse<T>(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<T>?,
    @SerializedName("aggregations") val aggregations: List<Aggregations>?,
    @SerializedName("search_tracking_id") val search_tracking_id: String
)