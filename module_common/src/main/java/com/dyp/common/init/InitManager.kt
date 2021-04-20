package com.dyp.common.init

object InitManager {
    private val list = ArrayList<InitEvent>()

    fun init() {
        list.sortBy { it.priority }

        for (event in list) {
            event.event
        }
    }

    fun addEvent(priority: Int, event: () -> Unit) {
        list.add(InitEvent(priority, event))
    }
}