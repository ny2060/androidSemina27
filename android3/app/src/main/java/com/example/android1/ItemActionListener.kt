package com.example.android1

import android.view.View

interface ItemActionListener {
    fun onItemMoved(from: Int, to: Int)
    fun onItemSwiped(position: Int)
    abstract fun SampleViewholder(itemview: View?): SampleViewholder
}