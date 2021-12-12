package com.example.udemyapp.data.course

import com.google.gson.annotations.SerializedName

data class Aggregations (

	@SerializedName("id") val id : String,
	@SerializedName("title") val title : String,
	@SerializedName("options") val options : List<Options>
)