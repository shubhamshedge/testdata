package com.example.iiflprojecttask.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.iiflprojecttask.models.LoginModel
import com.example.iiflprojecttask.repository.LoginRepository

class LoginViewModel : ViewModel() {

    lateinit var repository : LoginRepository
    var liveDataLogin: LiveData<LoginModel>? = null

    fun init(requireContext: Context) {
        repository = LoginRepository(requireContext)
        liveDataLogin = repository.getVolumesResponseLiveData()
    }

    fun getLoginDetails(context: Context, email: String,password : String) {
        repository.callLoginAPI(context!!,email,password)
    }
    fun getVolumesResponseLiveData(): LiveData<LoginModel>? {
        return liveDataLogin
    }
}