package com.example.week3_sns_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week3_sns_project.databinding.FragmentMypageBinding

class MypageFragment : Fragment() {
    private lateinit var binding: FragmentMypageBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMypageBinding.inflate(inflater,container,false)

        Log.d("LoginData", MainActivity.loginDataModel.toString())

        val id = MainActivity.loginDataModel.id
        val name = MainActivity.loginDataModel.name

        binding.mypageId?.text = id
        binding.mypageName?.text = name

        return binding.root
    }

}