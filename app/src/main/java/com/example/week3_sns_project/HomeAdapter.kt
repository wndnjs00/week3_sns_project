package com.example.week3_sns_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeAdapter(private val itemList: ArrayList<DataModel>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

        var onItemClick : ((DataModel) -> Unit)? = null


    class HomeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val nickname = itemView.findViewById<TextView>(R.id.home_bts_textview2)
        val title = itemView.findViewById<TextView>(R.id.home_title_textview)
        val image = itemView.findViewById<ImageView>(R.id.home_bts_imageview2)
    }



    // 레이아웃 연결
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item_list, parent,false)
        return HomeViewHolder(view)
    }


    // 개수 리턴
    override fun getItemCount(): Int {
       return itemList.size
    }


    // 데이터 연결
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        val list = itemList[position]

        holder.nickname.text = list.nickName
        holder.title.text = list.title
        holder.image.setImageResource(list.image)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list)
        }

    }

    }
