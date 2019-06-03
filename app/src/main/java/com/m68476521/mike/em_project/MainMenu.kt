package com.m68476521.mike.em_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.m68476521.mike.em_project.mainMenu.MainMenuAdapter
import com.m68476521.mike.em_project.utils.ApiManager
import com.m68476521.mike.em_project.utils.DataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main_menu.*

/**
 * Main Menu fragment
 * by m68476521.com
 */
class MainMenu : Fragment() {
    private val compositeDisposable = CompositeDisposable()
    private val adapter = MainMenuAdapter()
    private lateinit var model: DataModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerMenu.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        recyclerMenu.itemAnimator = DefaultItemAnimator()
        recyclerMenu.adapter = adapter
        getData()
    }

    private fun getData() {
        ApiManager.setUp()
        val eventsDisposable = ApiManager.api.getPublicCharacters(10)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                model = ViewModelProviders.of(requireActivity()).get(DataModel::class.java)
                model.results = it.data.results
                adapter.swapResults(it.data.results)
            }, { it.printStackTrace() })
        compositeDisposable.add(eventsDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
