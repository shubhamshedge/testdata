package com.example.iiflprojecttask.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.iiflprojecttask.R
import com.example.iiflprojecttask.adapter.ProjectAdapter
import com.example.iiflprojecttask.adapter.ScriptAdapter
import com.example.iiflprojecttask.databinding.TabOneFragmentBinding
import com.example.iiflprojecttask.models.*
import com.example.iiflprojecttask.viewmodel.LoginViewModel
import com.example.iiflprojecttask.viewmodel.TabOneViewModel


class TabOneFragment : Fragment(){
    private var _binding: TabOneFragmentBinding? = null
    private val binding get() = _binding!!
    private var projectAdapter: ProjectAdapter? = null
    private var projectAdapter2: ProjectAdapter? = null
    private var scriptAdapter: ScriptAdapter? = null
    lateinit var viewModel: TabOneViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TabOneFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(TabOneViewModel::class.java)
        scriptAdapter = ScriptAdapter()
        binding.rvCompanydata.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCompanydata.adapter = scriptAdapter
        observeViewModel(viewModel)

        projectAdapter = ProjectAdapter()
        binding.rvViewOne.layoutManager = LinearLayoutManager(requireContext())
        binding.rvViewOne.adapter = projectAdapter

        projectAdapter2 = ProjectAdapter()
        binding.rvViewTwo.layoutManager = LinearLayoutManager(requireContext())
        binding.rvViewTwo.adapter = projectAdapter2

        viewModel.init(requireContext())
        var requestHead = RequestHead("IIFLMarkets","1.0.20.0","2cccc59bdab77bace6189d001f96487e",
        "Android","IIFLMarRQGetNewMarketWatchV5")
        var requestBody = RequestBody("c174431","NIFTY50",0)
        var scriptRequest = ScriptRequest(head = requestHead,body = requestBody)
        val header = mutableMapOf<String,String>()
        header["Content-Type"] = "application/json"
        header["UserId"] = "YaP29KW2g56"
        header["Password"] = "H63prL2Nm8"
        viewModel.callScriptDataAPI(scriptRequest,header)!!.observe(viewLifecycleOwner, Observer { serviceSetterGetter ->
            Log.d("IIFL", "onViewCreated: " + serviceSetterGetter.body!!.marketWatchName)
            scriptAdapter!!.setProjectList(serviceSetterGetter.body!!.data!!)

        })

        val viewOneRequest = ViewOneRequest("B",0)
        viewModel.callViewOneAPI(viewOneRequest,header)!!.observe(viewLifecycleOwner, Observer { gainer ->
            Log.d("IIFL", "onViewCreated: " + gainer.gainer)
            projectAdapter!!.setProjectList(gainer.gainer!!)

        })

        val viewOneRequest1 = ViewOneRequest("B",0)
        viewModel.callViewOneAPI(viewOneRequest1,header)!!.observe(viewLifecycleOwner, Observer { gainer ->
            Log.d("IIFL", "onViewCreated: " + gainer.looser)
            projectAdapter2!!.setProjectList(gainer.looser!!)

        })

    }

    private fun observeViewModel(viewModel: TabOneViewModel) {

    }
}