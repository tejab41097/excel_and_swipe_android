package com.example.excelsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val parentAdapter = ParentAdapter()
        findViewById<RecyclerView>(R.id.rv_parent).adapter = parentAdapter
        val callback: ItemTouchHelper.Callback = SimpleItemTouchHelperCallback(parentAdapter)
        val touchHelper = ItemTouchHelper(callback)
        touchHelper.attachToRecyclerView(findViewById(R.id.rv_parent))
        findViewById<RecyclerView>(R.id.rv_parent).layoutManager = LinearLayoutManager(this)
    }
}