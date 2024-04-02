package com.example.week3_sns_project.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week3_sns_project.DetailActivity
import com.example.week3_sns_project.R
import com.example.week3_sns_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var itemList : ArrayList<DataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        itemList = ArrayList()

        itemList.add(DataModel(R.drawable.img_bts, "방탄 카페 용산점에 왔어요", "게시글 내용 어쩌구"))
        itemList.add(DataModel(R.drawable.img_btob, "비투비 콘서트 갔다왔어요!!","게시글 내용 어쩌구2"))


        val adapter = HomeAdapter(itemList)
        binding.homeRecyclerview.adapter = adapter


        adapter.onItemClick = {
            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }


        binding.homeRecyclerview.layoutManager = GridLayoutManager(context,1)




        return binding.root


    }





}