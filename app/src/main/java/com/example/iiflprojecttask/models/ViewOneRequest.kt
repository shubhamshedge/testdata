package com.example.iiflprojecttask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ViewOneRequest(
    @SerializedName("Exchange")
    @Expose
    var exchange: String? = null,
    @SerializedName("ClientLoginType")
    @Expose
    var clientLoginType: Int? = 0,
)