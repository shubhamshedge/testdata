package com.example.iiflprojecttask.network

import com.example.iiflprojecttask.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface APIServices {
    @GET("/repositories")
    fun retrieveRepositories(): Call<LoginModel>

    @POST("v5/GetNewMarketWatch")
    fun getScriptData(@Body script: ScriptRequest,
                      @HeaderMap headers: Map<String, String>): Call<ScriptModel>


    @POST("GainerLooser")
    fun getViewOneData(@Body viewOne: ViewOneRequest,
                       @HeaderMap headers: Map<String, String>): Call<GainerModel>
}