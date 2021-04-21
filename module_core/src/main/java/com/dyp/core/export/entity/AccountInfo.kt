package com.dyp.core.export.entity

data class AccountInfo(
    @JvmField var id: Int = 0,
    @JvmField var name: String = ""
) {
    companion object {
        const val NAME = "account_info"
    }
}