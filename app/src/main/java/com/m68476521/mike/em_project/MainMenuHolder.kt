package com.m68476521.mike.em_project

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em.Results
import kotlinx.android.synthetic.main.item_main_menu.view.*

class MainMenuHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindResult(result: Results) = itemView.name.text = result.name
}