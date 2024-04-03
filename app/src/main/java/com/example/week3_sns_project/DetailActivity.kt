package com.example.week3_sns_project

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val back_btn = findViewById<ImageButton>(R.id.detail_back_imgbtn)
        back_btn.setOnClickListener {
            finish()
        }

        val heart_btn = findViewById<ImageButton>(R.id.detail_heart_imgbtn)
        val empty_btn = findViewById<ImageButton>(R.id.detail_empty_imgbtn)
        val post_title_tv = findViewById<TextView>(R.id.detail_title_textview)
        val post_content_tv = findViewById<TextView>(R.id.detail_post_textview)
        val idol_image = findViewById<ImageView>(R.id.detail_img_imgview)


        empty_btn.setOnClickListener {
            if(heart_btn.visibility == View.VISIBLE) {
                heart_btn.visibility = View.INVISIBLE
            } else {
                heart_btn.visibility = View.VISIBLE
            }
        }

        heart_btn.setOnClickListener {
            if(heart_btn.visibility == View.VISIBLE) {
                heart_btn.visibility = View.INVISIBLE
            } else {
                heart_btn.visibility = View.VISIBLE
            }
        }


        // HomeFragment에서 보낸 데이터 받아오기
        val title = intent.extras?.getString("title")
        val content = intent.extras?.getString("content")
        val image = intent.extras?.getInt("image")


        post_title_tv.text = title
        post_content_tv.text = content

        if (image != null) {
            idol_image.setImageResource(image)
        }


    }
}