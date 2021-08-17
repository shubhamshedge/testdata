package com.example.iiflprojecttask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ScriptRequest(
    @SerializedName("body")
    @Expose
    var body: RequestBody? = null,
    @SerializedName("head")
    @Expose
    var head: RequestHead? = null,
)