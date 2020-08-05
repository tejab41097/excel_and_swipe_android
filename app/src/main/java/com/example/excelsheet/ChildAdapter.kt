package com.example.excelsheet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.excelsheet.databinding.ItemChildBinding

class ChildAdapter : RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemChildBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = 8

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position == 0) {
            holder.itemBinding.clTitle.visibility = View.VISIBLE
            holder.itemBinding.clNormal.visibility = View.GONE
            holder.itemBinding.title.text = "Title 1"
            holder.itemBinding.title2.text = "Title 2"
            holder.itemBinding.title3.text = "Title 3"
            holder.itemBinding.title4.text = "Title 4"
        }else{
            holder.itemBinding.tv1.text = "value 1"
            holder.itemBinding.tv2.text = "value 2"
            holder.itemBinding.tv3.text = "value 3"
            holder.itemBinding.tv4.text = "value 4"
        }
    }

    class ViewHolder(val itemBinding: ItemChildBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}