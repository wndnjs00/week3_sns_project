package com.example.week3_sns_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        binding.mypageIdTextview2?.text = id
        binding.mypageNameTextview2?.text = name

        spinnerIdol()
        spinnerIdolResult()

        return binding.root
    }


    // spinner의 값을 결정하는 함수
    fun spinnerIdol(){

        val idol = resources.getStringArray(R.array.itemList)

        val Adapter = context?.let { ArrayAdapter(it, R.layout.item_spinner, idol) }

        binding.mypageSpinner?.adapter = Adapter
    }


    fun spinnerIdolResult(){

        binding.mypageSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.mypageArtistTextview2.text = "${binding.mypageSpinner?.getItemAtPosition(position)}"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

}