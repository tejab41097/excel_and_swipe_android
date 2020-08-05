package com.example.excelsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.excelsheet.databinding.ItemExcelSheetBinding
import java.util.*


class ParentAdapter : ItemTouchHelperAdapter, RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val collection = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemExcelSheetBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = 8

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBinding = holder.itemBinding
        collection.add("Week ${position + 1}")
        itemBinding.tvTitle.text = collection[position]

        if (position == 0)
            itemBinding.recyclerview.visibility = View.VISIBLE
        else
            itemBinding.recyclerview.visibility = View.GONE

        itemBinding.root.setOnClickListener {
            if (itemBinding.recyclerview.visibility == View.VISIBLE) {
                itemBinding.recyclerview.visibility = View.GONE
            } else {
                itemBinding.recyclerview.visibility = View.VISIBLE
            }
        }
        itemBinding.recyclerview.adapter = ChildAdapter()
        itemBinding.recyclerview.layoutManager =
            LinearLayoutManager(itemBinding.root.context, LinearLayoutManager.HORIZONTAL, false)
    }

    class ViewHolder(val itemBinding: ItemExcelSheetBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onItemDismiss(position: Int) {
        collection.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(collection, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(collection, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
//        return true
    }

}
