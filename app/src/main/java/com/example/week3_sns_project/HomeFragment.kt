package com.example.week3_sns_project

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week3_sns_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding      // 뷰바인딩 선언(초기화는 나중에)









    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 뷰바인딩 초기화
        binding = FragmentHomeBinding.inflate(inflater, container, false)








        val itemList = HomeList(resources)

        val adapter = HomeAdapter(itemList)             // HomeAdapter에 itemList데이터 담기
        binding.homeRecyclerview.adapter = adapter      // 리사이클러뷰 레이아웃과 어뎁터 연결 (어뎁터가 중간다리 역할이기 때문에 Fragment와 Adapter를 연결시켜줘야함!!)


        // 어뎁터 아이템 클릭시
        adapter.onItemClick = {
            val intent = Intent(context, DetailActivity::class.java)
            // DetailActivity로 title, content, image에 관한 데이터 넘겨줌
            intent.putExtra("title",it.title)
            intent.putExtra("content",it.content)
            intent.putExtra("image",it.image)
            startActivity(intent)
        }


        // GridLayoutManager사용해 리사이클러뷰 아이템 한줄에 1개씩 배치
        binding.homeRecyclerview.layoutManager = GridLayoutManager(context,1)

        binding.homeBackground1Imageview.setOnClickListener {
            val intent = Intent(context, BtsActivity::class.java)
            startActivity(intent)
        }
        binding.homeBackground2Imageview.setOnClickListener {
            val intent = Intent(context, BtobActivity::class.java)
            startActivity(intent)
        }
        binding.homeBackground3Imageview.setOnClickListener {
            val intent = Intent(context, IdleActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }



    fun HomeList(resources: Resources) : ArrayList<DataModel>{

        return arrayListOf(
            DataModel(
                image = R.drawable.img_bts,
                title = resources.getString(R.string.title_content_tv),
                content = resources.getString(R.string.post_tv1),
                nickName = resources.getString(R.string.bts),
                profile_image = R.drawable.img_bts
            ),
            DataModel(
                image = R.drawable.img_btob,
                title = resources.getString(R.string.title_content_tv2),
                content = resources.getString(R.string.post_tv2),
                nickName = resources.getString(R.string.btob),
                profile_image = R.drawable.img_btob
            )
        )

    }
}
