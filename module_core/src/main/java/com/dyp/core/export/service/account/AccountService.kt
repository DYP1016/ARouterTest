package com.dyp.core.export.service.account

import com.alibaba.android.arouter.facade.template.IProvider

interface AccountService : IProvider {
    fun test(name: String)

}