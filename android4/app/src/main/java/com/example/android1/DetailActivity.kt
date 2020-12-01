package com.example.android1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        title1.text = intent.getStringExtra("title")
        subtitle2.text = intent.getStringExtra("subtitle")
        date3.text = intent.getStringExtra("date")
        detail4.text = intent.getStringExtra("detail")

        // SharedPreferences 안에 값이 저장되어 있지 않을 때 -> Login

    }


}