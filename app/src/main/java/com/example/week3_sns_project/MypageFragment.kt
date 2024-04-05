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
        // itemList불러오기
        val idol = resources.getStringArray(R.array.itemList)
        // item_spinner를 어뎁터에 적용
        val Adapter = context?.let { ArrayAdapter(it, R.layout.item_spinner, idol) }

        // mypageSpinner와 어뎁터 연결
        binding.mypageSpinner?.adapter = Adapter
    }


    // 선택시 결과를 출력해주는 함수
    fun spinnerIdolResult(){

        binding.mypageSpinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                // mypageArtistTextview2에 mypageSpinner에서 선택한값이 적용되도록
                binding.mypageArtistTextview2.text = "${binding.mypageSpinner?.getItemAtPosition(position)}"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

}