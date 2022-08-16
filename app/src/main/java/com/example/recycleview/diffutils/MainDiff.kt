package com.example.recycleview.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.example.recycleview.model.MainData

class MainDiff(private val new: List<MainData>, private val old: List<MainData>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return new[newItemPosition].title == old[oldItemPosition].title
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return new[newItemPosition] == old[oldItemPosition]
    }
}