package com.m68476521.mike.em_project.utils

import com.m68476521.mike.em.EmManager
import com.m68476521.mike.em.EmService

private const val url = ""
private const val key = ""
private const val hash = ""

object ApiManager {
    lateinit var api: EmManager
        private set

    fun setUp() {
        val service = EmService.create(url, key, hash)
        api = EmManager(service)
    }
}