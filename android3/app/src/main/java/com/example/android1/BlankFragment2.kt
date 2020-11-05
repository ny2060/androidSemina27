package com.example.fragmentsemina

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android1.DetailActivity
import com.example.android1.R
import com.example.android1.SampleAdapter
import com.example.android1.SampleData
import kotlinx.android.synthetic.main.activity_recyclerview.*
import kotlinx.android.synthetic.main.fragment_blank2.*


class BlankFragment2 : Fragment() {


    private lateinit var sampleAdapter : SampleAdapter
    lateinit var recyclerView1 : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_blank2, container, false)
        sampleAdapter = SampleAdapter(requireContext())

        recyclerView1 = rootView.findViewById(R.id.rcv2!!)as RecyclerView



        recyclerView1.adapter = sampleAdapter
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
       // rcv.adapter=sampleAdapter
        //rcv.layoutManager = LinearLayoutManager(this)
      //  rcv.layoutManager = LinearLayoutManager(requireContext())

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

        return rootView
    }





}