package com.example.udemyapp.data.course

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PriceDetails(
    @SerializedName("amount") val amount: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("price_string") val price_string: String,
    @SerializedName("currency_symbol") val currency_symbol: String
) : Parcelable