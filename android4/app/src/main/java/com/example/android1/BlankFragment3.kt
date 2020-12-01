package com.example.fragmentsemina

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android1.MainActivity
import com.example.android1.R
import com.example.android1.SignUpActivity
import kotlinx.android.synthetic.main.fragment_blank3.view.*


class BlankFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val v=inflater.inflate(R.layout.fragment_blank3, container, false)


        v.button3.setOnClickListener {
            val builder =AlertDialog.Builder(ContextThemeWrapper(context,R.style.Theme_AppCompat_DayNight_Dialog))
            builder.setTitle("로그아웃하시겠습니까?")
            builder.setMessage("")
            builder.setPositiveButton("확인"){yes,id->
                Toast.makeText(context,"로그아웃 되었습니다",Toast.LENGTH_SHORT).show()
                val intent= Intent(context,MainActivity::class.java)
                startActivity(intent)
                activity?.finish()


            }

            builder.setNegativeButton("취소"){
                no,id->


            }
            builder.show()
        }

        return v
    }


}