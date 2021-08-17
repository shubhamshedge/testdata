package com.example.iiflprojecttask.repository

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iiflprojecttask.models.*
import com.example.iiflprojecttask.network.APIServices
import com.example.iiflprojecttask.room.DAOAccess
import com.example.iiflprojecttask.room.LoginDatabase
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ScriptRepository(var requireContext: Context) {

    private val service: APIServices
    private lateinit var daoAccess: DAOAccess
    val BASE_URL = "https://swaraj.indiainfoline.com/Mob/Service1.svc/"
    val serviceSetterGetter = MutableLiveData<ScriptModel>()
    val viewOneLiveData = MutableLiveData<GainerModel>()
    var loginDatabase: LoginDatabase? = null
    private var mAllPosts: LiveData<List<DataList>>
    var webserviceResponseList: List<TestModel> = ArrayList()

    init {
        loginDatabase = initializeDB(requireContext)
        daoAccess = loginDatabase!!.loginDao()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIServices::class.java)

        mAllPosts = daoAccess.getAllPosts()
    }

    fun initializeDB(context: Context): LoginDatabase {
        return LoginDatabase.getDataseClient(context)
    }

    fun getAllPosts(): LiveData<List<DataList>> {
        return mAllPosts
    }


    fun getServicesApiCall(
        scriptRequest: ScriptRequest,
        headers: Map<String, String>
    ): MutableLiveData<ScriptModel> {

        val call = service.getScriptData(scriptRequest, headers)

        call.enqueue(object : Callback<ScriptModel> {
            override fun onFailure(call: Call<ScriptModel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<ScriptModel>,
                response: Response<ScriptModel>
            ) {
                Log.v("DEBUG : ", response.body().toString())
                val data = response.body()
//                webserviceResponseList = parseJson(response.body()!!.body)
//                insertScriptData(webserviceResponseList)
                serviceSetterGetter.value = data
            }
        })

        return serviceSetterGetter
    }

    private fun parseJson(body: Body?): List<TestModel> {
        val apiResults = ArrayList<TestModel>()
        val jsonObject: JSONObject
        val jsonArray: JSONArray

        try {
            jsonArray = JSONArray(body!!.data.toString())
            for (i in 0 until jsonArray.length()) {
                var jsonInfo: JSONObject = jsonArray.getJSONObject(i)
                val mMovieModel = TestModel()
                mMovieModel.setId(i)
//                mMovieModel.setDayHigh(jsonInfo.getString("DayHigh").toDouble())
                apiResults.add(mMovieModel)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return apiResults
    }

    fun insertScriptData(data: List<DataList>) {
        InsertAsyncTask(daoAccess).execute(data)
    }


    fun getViewOneApiCall(
        viewOneRequest: ViewOneRequest,
        headers: Map<String, String>
    ): MutableLiveData<GainerModel> {

        val call = service.getViewOneData(viewOneRequest, headers)

        call.enqueue(object : Callback<GainerModel> {
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


    fun getViewTwoApiCall(
        scriptRequest: ScriptRequest,
        headers: Map<String, String>
    ): MutableLiveData<ScriptModel> {

        val call = service.getScriptData(scriptRequest, headers)

        call.enqueue(object : Callback<ScriptModel> {
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


    //insert data in room db.
    class InsertAsyncTask internal constructor(postInfoDao: DAOAccess) :
        AsyncTask<List<DataList>, Void, Void>() {
        private var mAsyncUserDao: DAOAccess

        init {
            mAsyncUserDao = postInfoDao
        }

        override fun doInBackground(vararg p0: List<DataList>): Void? {
            /*for(item in p0[0].indices){
                mAsyncUserDao.insertPosts(p0[0][item])
            }*/
            if (p0[0] != null) {
                mAsyncUserDao.insertPosts(p0[0])
            }
            return null

        }
    }

}