package com.example.android1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.fragmentsemina.BlankFragment
import com.example.fragmentsemina.BlankFragment2
import com.example.fragmentsemina.BlankFragment3
import java.lang.IllegalStateException

class Tablayoutadapter (fm : FragmentManager)
    : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    var fragmentss= listOf<Fragment>()
    override fun getItem(position: Int): Fragment =when(position){
        0->BlankFragment2()
        1->BlankFragment3()

        else -> throw IllegalStateException("unexpected position $position")
    }

    override fun getCount(): Int =2





}