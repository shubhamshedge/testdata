package com.example.iiflprojecttask.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.iiflprojecttask.models.*
import com.example.iiflprojecttask.repository.ScriptRepository

class TabOneViewModel : ViewModel() {

    lateinit var repository: ScriptRepository
    var liveDataScript: LiveData<ScriptModel>? = MutableLiveData<ScriptModel>()
    var liveDataViewOne: LiveData<GainerModel>? = MutableLiveData<GainerModel>()
    var liveDataViewTwo: LiveData<ScriptModel>? = MutableLiveData<ScriptModel>()
    private lateinit var mAllPosts: LiveData<List<DataList>>

    fun init(requireContext: Context) {
        repository = ScriptRepository(requireContext)
        mAllPosts  = repository.getAllPosts()
    }

    fun getAllPosts(): LiveData<List<DataList>> {
        return mAllPosts
    }

    fun callScriptDataAPI(
        scriptRequest: ScriptRequest,
        header: Map<String, String>
    ): LiveData<ScriptModel>? {
        liveDataScript = repository.getServicesApiCall(scriptRequest, header)
        return liveDataScript
    }

    fun insertAllScript(data : List<DataList>){
        repository.insertScriptData(data)
    }


    fun callViewOneAPI(
        viewOneRequest: ViewOneRequest,
        header: Map<String, String>
    ): LiveData<GainerModel>? {
        liveDataViewOne = repository.getViewOneApiCall(viewOneRequest, header)
        return liveDataViewOne
    }

}