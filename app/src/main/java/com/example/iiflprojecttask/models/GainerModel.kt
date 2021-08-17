package com.example.iiflprojecttask.models

import com.google.gson.annotations.SerializedName

class GainerModel {
    @SerializedName("CacheTime")
    val cacheTime: Long? = null

    @SerializedName("Gainer")
    val gainer: List<Gainer>? = null

    @SerializedName("Looser")
    val looser: List<Gainer>? = null

    @SerializedName("Message")
    val message: String? = null

    @SerializedName("Status")
    val status: Long? = null
}

class Gainer {
    @SerializedName("Exch")
    val exch: String? = null

    @SerializedName("ExchType")
    val exchType: String? = null

    @SerializedName("FullName")
    val fullName: String? = null

    @SerializedName("LTP")
    val ltp: Double? = null

    @SerializedName("PerChange")
    val perChange: Double? = null

    @SerializedName("ScripCode")
    val scripCode: Long? = null

    @SerializedName("Symbol")
    val symbol: String? = null

    @SerializedName("Volume")
    val volume: Long? = null
}
