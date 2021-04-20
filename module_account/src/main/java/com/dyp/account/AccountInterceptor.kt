package com.dyp.account

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.dyp.common.base.logI
import com.dyp.core.config.AppConst

@Interceptor(priority = 3, name = AppConst.Router.Account.NAME + "checkLogin")
class AccountInterceptor : IInterceptor {
    override fun init(context: Context?) {

    }

    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        logI("process: ${postcard?.action}")
        callback?.onContinue(postcard)
    }
}