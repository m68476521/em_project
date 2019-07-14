package com.m68476521.mike.em_project.comics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.m68476521.mike.em_project.R
import com.m68476521.mike.em_project.utils.DataModel
import kotlinx.android.synthetic.main.fragment_comics.*

/**
 * by m68476521.com
 *
 */
class ComicsFragment : Fragment() {
    private val args: ComicsFragmentArgs by navArgs()
    private lateinit var model: DataModel

    private var itemsAdapter = ItemsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProviders.of(requireActivity()).get(DataModel::class.java)
        val item = model.results.find { it.id == args.id }

        listOfItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        listOfItems.adapter = itemsAdapter

        if (item != null) {
            title.text = item.name
            available.text = item.comics.available.toString()
            description.text = item.description
            itemsAdapter.setItems(item.comics.items)
        }
    }
}
