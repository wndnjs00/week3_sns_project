package com.example.week3_sns_project

import android.content.Context
import androidx.annotation.StringRes

// string을 데이터클래스에 사용하기위한 클래스
class StringModel (
    private val stringId : Int,
    private vararg val params :  Any) {


    fun toString(context : Context) : String =
        context.getString(stringId, processParams(context).toTypedArray())


    private fun processParams(context: Context) =
        params.map{
            when(it){
                is Int -> context.resources.getString(it)
                is StringModel -> it.toString(context)
                else -> it
            }
        }


}

