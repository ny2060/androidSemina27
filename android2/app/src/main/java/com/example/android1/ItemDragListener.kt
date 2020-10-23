package com.example.android1

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface ItemDragListener {
    abstract var itemTouchHelper: ItemTouchHelper

    fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
}