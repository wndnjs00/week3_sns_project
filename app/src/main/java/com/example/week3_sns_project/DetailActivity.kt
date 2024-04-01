package com.example.week3_sns_project

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
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

    }
}