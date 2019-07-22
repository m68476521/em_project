package com.m68476521.mike.em_project.utils

import androidx.lifecycle.ViewModel
import com.m68476521.mike.em.ComicWrapper
import com.m68476521.mike.em.Results

/**
 * Developed by m68476521.com
 *
 */

class DataModel : ViewModel() {
    var results: List<Results> = emptyList()
    lateinit var listOfComics: ComicWrapper
}