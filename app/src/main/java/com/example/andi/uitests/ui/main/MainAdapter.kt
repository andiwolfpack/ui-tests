package com.example.andi.uitests.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andi.uitests.R
import kotlinx.android.synthetic.main.guys_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private lateinit var guys: MutableList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.guys_item, parent, false)
        return ViewHolder(root)
    }

    fun updateData(guys: List<String>) {
        this.guys.clear()
        this.guys.addAll(guys)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return guys.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateData(guys[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun updateData(guy: String) {
            itemView.item_guys_name.text = guy
        }
    }
}