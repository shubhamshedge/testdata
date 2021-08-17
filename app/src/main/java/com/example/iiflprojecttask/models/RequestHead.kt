package com.example.iiflprojecttask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestHead(
    @SerializedName("appName")
    @Expose
    val appName: String,

    @SerializedName("appVer")
    @Expose
    val appVer: String,

    @SerializedName("key")
    @Expose
    val key: String,

    @SerializedName("osName")
    @Expose
    val osName: String,

    @SerializedName("requestCode")
    @Expose
    val requestCode: String
)