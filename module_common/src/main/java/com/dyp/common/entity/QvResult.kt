package com.dyp.common.entity

data class QvResult<T>(
    var code: Int = 0,
    var result: T? = null
) {
    fun retSuccess(): Boolean {
        return code == 0
    }
}