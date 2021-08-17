package com.example.iiflprojecttask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.iiflprojecttask.databinding.FragmentFirstBinding
import com.example.iiflprojecttask.models.LoginModel
import com.example.iiflprojecttask.viewmodel.LoginViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var strUsername: String
    lateinit var strPassword: String
    lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.init(requireContext())
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            strUsername = binding.etEmail.text.toString().trim()
            strPassword = binding.etPassword.text.toString().trim()

           /* if (strPassword.isEmpty()) {
                binding.etEmail.error = "Please enter the username"
            }
            else if (strPassword.isEmpty()) {
                binding.etPassword.error = "Please enter the username"
            }
            else {
                loginViewModel.getLoginDetails(requireContext(), strUsername, strPassword)
            }*/
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        loginViewModel.getVolumesResponseLiveData()?.observe(viewLifecycleOwner, object : Observer<LoginModel> {
            override fun onChanged(volumesResponse: LoginModel?) {
                if (volumesResponse != null) {
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}