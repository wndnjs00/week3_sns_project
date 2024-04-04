package com.example.week3_sns_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// RecyclerView.Adapter<HomeAdapter.HomeViewHolder> 상속받음
class HomeAdapter(private val itemList: ArrayList<DataModel>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    // 클릭 이벤트 추가부분
    var onItemClick : ((DataModel) -> Unit)? = null


    // ViewHolder는 기본적으로 화면에 표시될데이터나 아이템들 저장하는 역할
    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nickname = itemView.findViewById<TextView>(R.id.home_bts_textview2)
        val title = itemView.findViewById<TextView>(R.id.home_title_textview)
        val image = itemView.findViewById<ImageView>(R.id.home_bts_imageview2)
        val profile_img = itemView.findViewById<ImageView>(R.id.home_profile_imageview)
    }



    // 뷰가 만들어질때 호출되는 메소드 (레이아웃 연결)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item_list, parent,false)
        return HomeViewHolder(view)     // HomeViewHolder에 레이아웃 담아서 리턴
    }


    // 개수 리턴
    override fun getItemCount(): Int {
       return itemList.size     // 리스트아이템의 사이즈 리턴 (숫자 2넣으면 아이템 2개만 리턴)
    }


    // 데이터 연결
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        // HomeViewHolder에 데이터를 연결
        holder.nickname.text = itemList[position].nickName
        holder.title.text = itemList[position].title
        holder.image.setImageResource(itemList[position].image)
        holder.profile_img.setImageResource(itemList[position].image)

        // 클릭 이벤트 추가
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(itemList[position])
        }

    }

    }
