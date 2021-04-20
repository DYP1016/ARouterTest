package com.dyp.core.export.service.main

import com.alibaba.android.arouter.facade.template.IProvider

interface MainService : IProvider {
    fun test(name: String)

    fun test2(input: Int, callBack: () -> Int)
}