package com.example.iiflprojecttask.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ScriptModel {
    @SerializedName("body")
    @Expose
    var body: Body? = null

    @SerializedName("head")
    @Expose
    var head: Head? = null
}

class Head {
    @SerializedName("responseCode")
    @Expose
    var responseCode: String? = null

    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("statusDescription")
    @Expose
    var statusDescription: String? = null
}

class Body {
    @SerializedName("Data")
    @Expose
    var data: List<DataList>? = null

    @SerializedName("MarketWatchName")
    @Expose
    var marketWatchName: String? = null

    @SerializedName("Message")
    @Expose
    var message: String? = null

    @SerializedName("Status")
    @Expose
    var status: Int? = null
}

class DataList {
    @SerializedName("DayHigh")
    @Expose
    var dayHigh: Double? = null

    @SerializedName("DayLow")
    @Expose
    var dayLow: Double? = null

    @SerializedName("EPS")
    @Expose
    var eps: Int? = null

    @SerializedName("Exch")
    @Expose
    var exch: String? = null

    @SerializedName("ExchType")
    @Expose
    var exchType: String? = null

    @SerializedName("FullName")
    @Expose
    var fullName: String? = null

    @SerializedName("High52Week")
    @Expose
    var high52Week: Double? = null

    @SerializedName("LastTradePrice")
    @Expose
    var lastTradePrice: Double? = null

    @SerializedName("LastTradeTime")
    @Expose
    var lastTradeTime: String? = null

    @SerializedName("Low52Week")
    @Expose
    var low52Week: Double? = null

    @SerializedName("Month")
    @Expose
    var month: Double? = null

    @SerializedName("Name")
    @Expose
    var name: String? = null

    @SerializedName("NseBseCode")
    @Expose
    var nseBseCode: Int? = null

    @SerializedName("PClose")
    @Expose
    var pClose: Double? = null

    @SerializedName("PriceAsk")
    @Expose
    var priceAsk: Double? = null

    @SerializedName("PriceBid")
    @Expose
    var priceBid: Double? = null

    @SerializedName("QtyAsk")
    @Expose
    var qtyAsk: Int? = null

    @SerializedName("QtyBid")
    @Expose
    var qtyBid: Int? = null

    @SerializedName("Quarter")
    @Expose
    var quarter: Double? = null

    @SerializedName("ScripCode")
    @Expose
    var scripCode: Int? = null

    @SerializedName("ShortName")
    @Expose
    var shortName: String? = null

    @SerializedName("Volume")
    @Expose
    var volume: Int? = null

    @SerializedName("WireCat")
    @Expose
    var wireCat: String? = null

    @SerializedName("Year")
    @Expose
    var year: Double? = null
}
