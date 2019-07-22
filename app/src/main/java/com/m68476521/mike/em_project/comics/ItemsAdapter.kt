package com.m68476521.mike.em_project.comics

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em.ComicSummary
import com.m68476521.mike.em.ItemA
import com.m68476521.mike.em.Url
import com.m68476521.mike.em_project.R

class ItemsAdapter : RecyclerView.Adapter<ItemHolder>() {
    private var listOfItems: List<ComicSummary> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_view_comic_title,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(listOfItems[position].name)
    }

    override fun getItemCount(): Int = listOfItems.size

    fun setItems(items: List<ComicSummary>) {
        if (listOfItems == items)
            return

        listOfItems = items
        this.notifyDataSetChanged()
    }
}