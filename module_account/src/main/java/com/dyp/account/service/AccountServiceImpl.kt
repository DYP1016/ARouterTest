package com.dyp.account.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyp.common.base.logD
import com.dyp.core.config.AppConst
import com.dyp.core.export.service.account.AccountService

@Route(path = AppConst.Router.Account.S_ACCOUNT)
class AccountServiceImpl : AccountService {
    override fun test(name: String) {

    }

    override fun init(context: Context?) {
        logD("init")

    }
}