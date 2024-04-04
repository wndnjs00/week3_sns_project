package com.example.week3_sns_project

import androidx.annotation.DrawableRes

data class DataModel (
    @DrawableRes
    val image : Int ,            // drawable은 숫자로 인식
    val title : String,          // 제목
    val content : String,        // 내용
    val nickName : String,       // 닉네임
    val profile_image : Int   // 프로필 이미지

)

data class LoginDataModel(
    val id : String,
    val name : String
)
