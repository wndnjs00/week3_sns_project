package com.example.week3_sns_project

import android.content.Intent
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
    private lateinit var itemList : ArrayList<DataModel>    // 리스트에 DataModel을 담은 itemList선언

    // StringModel에 string값 넣어주기
    private val stringModel = StringModel(stringId = R.string.title_content_tv)
    private val stringModel2 = StringModel(stringId = R.string.title_content_tv2)
    private val stringModel3 = StringModel(stringId = R.string.post_tv1)
    private val stringModel4 = StringModel(stringId = R.string.post_tv2)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 뷰바인딩 초기화
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        // itemList 초기화
        itemList = ArrayList()

        // itemList에 image,title,content,nickname에 해당하는 데이터 추가
        // title,content에는 string값을 넣어줌
        itemList.add(DataModel(R.drawable.img_bts, stringModel.toString(requireContext()), stringModel3.toString(requireContext()), "BTS", R.drawable.img_bts))
        itemList.add(DataModel(R.drawable.img_btob, stringModel2.toString(requireContext()), stringModel4.toString(requireContext()), "BTOB", R.drawable.img_btob))


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

        return binding.root
    }
}