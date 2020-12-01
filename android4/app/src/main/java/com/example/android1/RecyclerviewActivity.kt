package com.example.android1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var sampleAdapter : SampleAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)





        sampleAdapter = SampleAdapter(this)



        rcv.adapter=sampleAdapter
        //rcv.layoutManager = LinearLayoutManager(this)
        rcv.layoutManager = GridLayoutManager(this,2)

        sampleAdapter.data = mutableListOf(
            SampleData(" 이름","안나영","20/10/18","이름은 안나영 별명은 기억이안나영, 생각이안나영, 이손안나입니다."),
            SampleData(" 나이","22살","20/10/18","생년월일은 1999년 8월 17일입니다."),
            SampleData(" 파트","안드로이드","20/10/18","현재 안드로이드 파트원이며" +
                    "파이썬 ,JAVA,C언어를 사용하고있습니다."),
            SampleData(" 취미","노는것","20/10/18","노는것을 좋아하며 보드게임, 레저스포츠 등등을 좋아합니다."),
        )
        sampleAdapter.notifyDataSetChanged()

        sampleAdapter.setItemClickListener( object : SampleAdapter.ItemClickListener{
            override fun onClick(view: View, position: Int) {
                val item = sampleAdapter.data [position]
                Log.d("SSS", "${position}번 리스트 선택")
                val intent = Intent(view.context, DetailActivity::class.java)
                intent.putExtra("title",item.title)
                intent.putExtra("subtitle",item.subTitle)
                intent.putExtra("date",item.date)
                intent.putExtra("detail",item.detail)
                startActivity(intent)
            }
        })
    }



}