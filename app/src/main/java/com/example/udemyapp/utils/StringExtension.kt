package com.example.udemyapp.utils

import android.util.Base64

fun String.getBase46():String{
    return Base64.encodeToString(this.toByteArray(), Base64.NO_WRAP)
}