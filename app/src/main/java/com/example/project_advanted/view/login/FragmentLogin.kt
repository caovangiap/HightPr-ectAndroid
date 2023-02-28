package com.example.project_advanted.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.project_advanted.databinding.FragmentLoginBinding
import com.example.project_advanted.databinding.FragmentLoginBindingImpl

class FragmentLogin : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var mView : View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        mView = binding.root
        return mView
    }
}