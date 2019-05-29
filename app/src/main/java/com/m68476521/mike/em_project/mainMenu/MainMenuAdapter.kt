package com.m68476521.mike.em_project.mainMenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em.Results
import com.m68476521.mike.em_project.MainMenuHolder
import com.m68476521.mike.em_project.R

class MainMenuAdapter : RecyclerView.Adapter<MainMenuHolder>() {
    private var listOfData: List<Results> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuHolder {
        return MainMenuHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main_menu, parent, false))
    }

    override fun getItemCount(): Int = listOfData.size

    override fun onBindViewHolder(holder: MainMenuHolder, position: Int) {
        holder.bindResult(listOfData[position])
    }

    fun swapResults(listOfResults: List<Results>) {
        if (this.listOfData == listOfResults)
            return

        this.listOfData = listOfResults
        this.notifyDataSetChanged()
    }
}