package com.dyp.common.init

internal data class InitEvent(
    val priority: Int,
    val event: () -> Unit
)