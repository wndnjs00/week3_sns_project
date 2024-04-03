package com.example.week3_sns_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        BottomNavigation()

        val emailData = intent.getStringExtra("email")
        val nameData = intent.getStringExtra("name")
        val intentToMyPage = Intent(this, MypageFragment::class.java)
    }



    // bottomNavigation 구현함수
    private fun BottomNavigation(){


        val bottom_nav = findViewById<BottomNavigationView>(R.id.main_bottomnavgation)


        // main_framelayout레이아웃을 HomeFragment로 대체
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_framelayout, HomeFragment())
            .commitAllowingStateLoss()


        bottom_nav.setOnItemSelectedListener { item ->

            when (item.itemId){

                // home클릭시 HomeFragment()로 대체
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // mypage클릭시 MypageFragment()로 대체
                R.id.mypage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, MypageFragment())
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }

            }
            false
        }


    }

}