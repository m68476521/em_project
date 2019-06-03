package com.m68476521.mike.em_project

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em.Results
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_menu.view.*

class MainMenuHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindResult(result: Results) = with(itemView) {
        itemView.name.text = result.name
        itemView.description.text = result.description
        var imageSource = "${result.thumbnail.path}.${result.thumbnail.extension}"
        imageSource = imageSource.replace("http", "https")
        Picasso.get()
            .load(imageSource)
            .into(itemView.imagePoster)

        setOnClickListener {
            val goToDetails = MainMenuDirections.actionMainMenuToDetailFragment()
            goToDetails.id = result.id
            it.findNavController().navigate(goToDetails)
        }
    }
}