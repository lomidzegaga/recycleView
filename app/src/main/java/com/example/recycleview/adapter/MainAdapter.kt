package com.example.recycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.CustomItemBinding
import com.example.recycleview.diffutils.MainDiff
import com.example.recycleview.model.MainData

class MainAdapter :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val list = mutableListOf<MainData>()

    var itemClick: ((MainData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(CustomItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = list.size

    inner class MainViewHolder(private val binding: CustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val items = list[adapterPosition]
            binding.apply {
                textView.text = items.title
                imageView.setImageResource(items.image)

                itemView.setOnClickListener {
                    itemClick!!.invoke(items)
                }
            }
        }
    }

    fun setItems(newList: List<MainData>) {
        val diff = MainDiff(new = newList, old = list)
        val result = DiffUtil.calculateDiff(diff)
        this.list.clear()
        this.list.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

}