package com.example.iiflprojecttask.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iiflprojecttask.models.LoginModel
import com.example.iiflprojecttask.models.ScriptRequest
import com.example.iiflprojecttask.network.APIServices
import com.example.iiflprojecttask.room.LoginDatabase
import com.example.iiflprojecttask.room.LoginTableModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class LoginRepository(var requireContext: Context) {

    private val service: APIServices
    val BASE_URL = "https://api.github.com/"
    private var volumesResponseLiveData: MutableLiveData<LoginModel>? = null
    var loginDatabase: LoginDatabase? = null
    var loginTableModel: LiveData<LoginTableModel>? = null

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(APIServices::class.java)

        //loginDatabase = initializeDB(requireContext)
    }

    fun initializeDB(context: Context) : LoginDatabase {
        return LoginDatabase.getDataseClient(context)
    }

    fun insertData(context: Context, username: String, password: String) {

        loginDatabase = initializeDB(context)

        /* CoroutineScope(IO).launch {
             val loginDetails = LoginTableModel(username, password)
             loginDatabase!!.loginDao().InsertData(loginDetails)
         }*/

    }

    fun getLoginDetails(context: Context, username: String) : LiveData<LoginTableModel>? {
//        loginTableModel = loginDatabase!!.loginDao().getLoginDetails(username)
        return loginTableModel
    }

    fun callLoginAPI(context : Context,email : String,pass : String) {
        volumesResponseLiveData = MutableLiveData()
        service.retrieveRepositories()
            .enqueue(object : Callback<LoginModel?> {
                override fun onResponse(
                    call: Call<LoginModel?>?,
                    response: Response<LoginModel?>
                ) {
                    if (response.body() != null) {
                        insertData(context!!,email,pass)
                        volumesResponseLiveData!!.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<LoginModel?>?, t: Throwable?) {
                    volumesResponseLiveData!!.postValue(null)
                }
            })
    }
    fun getVolumesResponseLiveData(): LiveData<LoginModel>? {
        return volumesResponseLiveData
    }

}