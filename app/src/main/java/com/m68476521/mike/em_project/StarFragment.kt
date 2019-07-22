package com.m68476521.mike.em_project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.m68476521.mike.em_project.utils.ApiManager
import com.m68476521.mike.em_project.utils.DataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * by m68476521.com
 *
 */
class StarFragment : Fragment() {
    private val compositeDisposable = CompositeDisposable()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_star, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        ApiManager.setUp()
        val eventsDisposable = ApiManager.api.getComics(20)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                val model = ViewModelProviders.of(requireActivity()).get(DataModel::class.java)
                model.listOfComics = it
                view?.findNavController()?.navigate(StarFragmentDirections.actionStarFragmentToMainMenu())
            }, {
                it.printStackTrace()
            })
        compositeDisposable.add(eventsDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}
