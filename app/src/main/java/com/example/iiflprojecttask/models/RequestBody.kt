package com.example.iiflprojecttask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RequestBody(
    @SerializedName("Clientcode")
    @Expose
    val clientcode: String,

    @SerializedName("MWName")
    @Expose
    val mwName: String,

    @SerializedName("ClientLoginType")
    @Expose
    val clientLoginType: Int
)