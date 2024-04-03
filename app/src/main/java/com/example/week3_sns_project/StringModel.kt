package com.example.week3_sns_project

import android.content.Context
import androidx.annotation.StringRes

class StringModel (
    private val contentId : Int,
    private vararg val params :  Any) {


    fun toString(context : Context) : String =
        context.getString(contentId, processParams(context).toTypedArray())


    private fun processParams(context: Context) =
        params.map{
            when(it){
                is Int -> context.resources.getString(it)
                is StringModel -> it.toString(context)
                else -> it
            }
        }


}

