package com.m68476521.mike.em_project.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.m68476521.mike.em_project.R
import com.m68476521.mike.em_project.utils.DataModel
import kotlinx.android.synthetic.main.details_card_view.view.*
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * Developed by m68476521.com
 *
 */
class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    private lateinit var model: DataModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        model = ViewModelProviders.of(requireActivity()).get(DataModel::class.java)
        val item = model.results.find { it.id == args.id }
        name.text = item?.name
        comics.nameDetail.text = getString(R.string.comics)
        series.nameDetail.text = getString(R.string.series)
        stories.nameDetail.text = getString(R.string.stories)
        events.nameDetail.text = getString(R.string.events)
        urls.nameDetail.text = getString(R.string.urls)
    }
}
