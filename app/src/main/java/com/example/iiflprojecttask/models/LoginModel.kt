package com.example.iiflprojecttask.models
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginModel {
    @SerializedName("kind")
    @Expose
    val kind: String? = null
    @SerializedName("totalItems")
    @Expose
    var totalItems = 0
}