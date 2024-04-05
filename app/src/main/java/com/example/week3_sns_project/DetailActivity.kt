package com.example.week3_sns_project

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
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
        val image = intent.extras?.getInt("image")      //image는 타입을 int로 설정했기때문에 getInt로 받아오기


        // 레이아웃과 데이터 연결
        post_title_tv.text = title
        post_content_tv.text = content

        if (image != null) {
            idol_image.setImageResource(image)
        }


        post_content_tv.setOnClickListener(this)


    }

    override fun onClick(v: View?) {

        var post_tv = findViewById<TextView>(R.id.detail_post_textview)
        var postExtend_tv = findViewById<TextView>(R.id.detail_postextend_textview)

        if(post_tv.lineCount > 2) {
            post_tv.maxLines = 2
            postExtend_tv.visibility = View.VISIBLE
        }

    }


    override fun onResume() {
        super.onResume()

        var post_tv = findViewById<TextView>(R.id.detail_post_textview)
        var postExtend_tv = findViewById<TextView>(R.id.detail_postextend_textview)

        setViewMore(post_tv,postExtend_tv)



    }


   @SuppressLint("SuspiciousIndentation")
   private fun setViewMore(contentTextView: TextView, viewMoreTextView: TextView) {
        contentTextView.post {
            val lineCount  = contentTextView.layout.lineCount
                // ...이 있으면 더보기 버튼 활성화
                if (contentTextView.layout.getEllipsisCount(lineCount - 1) > 0) {
                    viewMoreTextView.visibility = View.VISIBLE

                    // 더보기 클릭시 버튼 사라지게, 최대 6줄까지 늘어남
                    viewMoreTextView.setOnClickListener {
                        contentTextView.maxLines = 6
                        viewMoreTextView.visibility = View.GONE
                    }

            }
        }


    }


}