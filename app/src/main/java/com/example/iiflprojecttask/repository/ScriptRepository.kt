package com.example.iiflprojecttask.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iiflprojecttask.models.GainerModel
import com.example.iiflprojecttask.models.ScriptModel
import com.example.iiflprojecttask.models.ScriptRequest
import com.example.iiflprojecttask.models.ViewOneRequest
import com.example.iiflprojecttask.network.APIServices
import com.example.iiflprojecttask.room.LoginDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ScriptRepository(var requireContext: Context) {

    private val service: APIServices
    val BASE_URL = "https://swaraj.indiainfoline.com/Mob/Service1.svc/"
    val serviceSetterGetter = MutableLiveData<ScriptModel>()
    val viewOneLiveData = MutableLiveData<GainerModel>()

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIServices::class.java)
    }

    fun getServicesApiCall(scriptRequest: ScriptRequest,headers : Map<String,String>): MutableLiveData<ScriptModel> {

        val call = service.getScriptData(scriptRequest,headers)

        call.enqueue(object: Callback<ScriptModel> {
            override fun onFailure(call: Call<ScriptModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<ScriptModel>,
                response: Response<ScriptModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                serviceSetterGetter.value = data
            }
        })

        return serviceSetterGetter
    }


    fun getViewOneApiCall(viewOneRequest: ViewOneRequest,headers : Map<String,String>): MutableLiveData<GainerModel> {

        val call = service.getViewOneData(viewOneRequest,headers)

        call.enqueue(object: Callback<GainerModel> {
            override fun onFailure(call: Call<GainerModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<GainerModel>,
                response: Response<GainerModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                viewOneLiveData.value = data
            }
        })

        return viewOneLiveData
    }


    fun getViewTwoApiCall(scriptRequest: ScriptRequest,headers : Map<String,String>): MutableLiveData<ScriptModel> {

        val call = service.getScriptData(scriptRequest,headers)

        call.enqueue(object: Callback<ScriptModel> {
            override fun onFailure(call: Call<ScriptModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }
            override fun onResponse(
                call: Call<ScriptModel>,
                response: Response<ScriptModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
                serviceSetterGetter.value = data
            }
        })

        return serviceSetterGetter
    }

}