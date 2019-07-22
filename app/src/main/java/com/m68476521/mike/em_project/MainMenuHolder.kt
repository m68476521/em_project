package com.m68476521.mike.em_project

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em.Comic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_main_menu.view.*

class MainMenuHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindResult(comic: Comic) = with(itemView) {
        itemView.name.text = comic.title
        itemView.description.text = comic.description
        var imageSource = "${comic.thumbnail.path}.${comic.thumbnail.extension}"
        imageSource = imageSource.replace("http", "https")
        Picasso.get()
            .load(imageSource)
            .into(itemView.imagePoster)

        setOnClickListener {
            val goToDetails = MainMenuDirections.actionMainMenuToDetailFragment()
            goToDetails.id = comic.id
            it.findNavController().navigate(goToDetails)
        }
    }
}