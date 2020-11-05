package com.example.android1

import com.example.fragmentsemina.BlankFragment
import com.example.fragmentsemina.BlankFragment2
import com.example.fragmentsemina.BlankFragment3



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_viewpager.*
import kotlinx.android.synthetic.main.activity_viewpager.sample_bottom_viewpager
import kotlinx.android.synthetic.main.fragment_blank.*
import kotlin.properties.Delegates

class ViewpagerActivity : AppCompatActivity() {
    var code =1

    private  lateinit var viewpagerAdapter: SampleViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)

        val fragment= BlankFragment()
        val fragment2= BlankFragment2()
        val activity1=TabviewpagerActivity()
        viewpagerAdapter= SampleViewpagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments= listOf(
            BlankFragment(),
            BlankFragment2(),
            BlankFragment3()
        )

        sample_bottom_viewpager.adapter=viewpagerAdapter




// ViewPager slide 시 BottomNavi 변경
        sample_bottom_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            // ViewPager의 페이지 중 하나가 선택된 경우
            override fun onPageSelected(position: Int) {
                sample_bottom_navi.menu.getItem(position).isChecked = true


            }
        })
//바텀 네비게이션 세팅
        sample_bottom_navi.setOnNavigationItemSelectedListener {
            var index by Delegates.notNull<Int>()
            when (it.itemId) {
                R.id.menu_account -> index = 0
                R.id.menu_camera -> index = 1
                R.id.menu_chat -> index = 2
            }
            sample_bottom_viewpager.currentItem = index
            true
        }


    }
}