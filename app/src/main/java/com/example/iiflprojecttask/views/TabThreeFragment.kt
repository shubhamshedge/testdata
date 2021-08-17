package com.example.iiflprojecttask.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iiflprojecttask.databinding.TabCommonFragmentBinding

class TabThreeFragment : Fragment(){
    private var _binding: TabCommonFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TabCommonFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}