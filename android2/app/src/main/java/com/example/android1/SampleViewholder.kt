package com.example.android1

import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.android1.R
import com.example.android1.SampleData


class SampleViewholder (itemview: View):RecyclerView.ViewHolder(itemview){


    private val title: TextView=itemview.findViewById(R.id.title)
    private val subtitle: TextView=itemview.findViewById(R.id.subtitle)




    fun onBind(data : SampleData){
        Log.d("Test","onBind 호출")
        title.text=data.title
        subtitle.text=data.subTitle
    }
}