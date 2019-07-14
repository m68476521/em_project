package com.m68476521.mike.em_project.comics

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_comic_title.view.*

class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(name: String) {
        itemView.title.text = name
    }
}