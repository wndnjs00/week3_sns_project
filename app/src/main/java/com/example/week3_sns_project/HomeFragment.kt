package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week3_sns_project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var itemList : ArrayList<DataModel>

    private val stringModel = StringModel(contentId = R.string.title_content_tv)
    private val stringModel2 = StringModel(contentId = R.string.title_content_tv2)
    private val stringModel3 = StringModel(contentId = R.string.post_tv1)
    private val stringModel4 = StringModel(contentId = R.string.post_tv2)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        itemList = ArrayList()

//        itemList.add(DataModel(R.drawable.img_bts, "방탄 카페 용산점에 왔어요", "게시글 내용1"))
//        itemList.add(DataModel(R.drawable.img_btob, "비투비 콘서트 갔다왔어요!!", "게시글 내용2"))
        itemList.add(DataModel(R.drawable.img_bts, stringModel.toString(requireContext()), stringModel3.toString(requireContext())))
        itemList.add(DataModel(R.drawable.img_btob, stringModel2.toString(requireContext()), stringModel4.toString(requireContext())))

        val adapter = HomeAdapter(itemList)
        binding.homeRecyclerview.adapter = adapter


        adapter.onItemClick = {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("title",it.title)
            intent.putExtra("content",it.content)
            intent.putExtra("image",it.image)
            startActivity(intent)
        }


        binding.homeRecyclerview.layoutManager = GridLayoutManager(context,1)


        return binding.root
    }

}