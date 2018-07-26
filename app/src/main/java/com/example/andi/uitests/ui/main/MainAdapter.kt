package com.example.andi.uitests.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andi.uitests.R

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    constructor() {
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.guys_item, parent, false)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}