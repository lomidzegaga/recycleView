package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.adapter.MainAdapter
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.model.MainData

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val list = mutableListOf<MainData>()

    private val adapter : MainAdapter by lazy {
        MainAdapter().also {
            binding.recycleView.adapter = it
            binding.recycleView.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        items()
        adapter.setItems(list)
        itemClick()
    }

    private fun items() {
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
        list.add(
            MainData("hello", R.drawable.ic_directions_run))
    }

    private fun itemClick() {
        adapter.itemClick = {
            Toast.makeText(this, "you clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}