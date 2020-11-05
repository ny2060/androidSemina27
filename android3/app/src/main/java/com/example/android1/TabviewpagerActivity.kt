package com.example.android1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmentsemina.BlankFragment2
import com.example.fragmentsemina.BlankFragment3
import kotlinx.android.synthetic.main.fragment_blank.*

class TabviewpagerActivity : AppCompatActivity() {
    private lateinit var viewpagerAdapter: SampleViewpagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_blank)
        viewpagerAdapter = SampleViewpagerAdapter(supportFragmentManager)
        viewpagerAdapter.fragments = listOf(
            BlankFragment2(),
            BlankFragment3(),

        )
        sample_tab_viewpager.adapter = viewpagerAdapter
// Tablayout과 연동
        sample_tab.setupWithViewPager(sample_tab_viewpager)
        sample_tab.apply {
            getTabAt(0)?.text = "첫 번째"
            getTabAt(1)?.text = "두 번째"
            getTabAt(2)?.text = "세 번째"
        }
    }
}
