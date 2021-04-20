package com.dyp.main.service

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.PretreatmentService
import com.dyp.common.base.logI
import com.dyp.core.config.AppConst

@Route(path = AppConst.Router.Main.NAME + "pre")
class PreMainServiceImpl : PretreatmentService {
    override fun init(context: Context?) {
        logI("init")
    }

    override fun onPretreatment(context: Context?, postcard: Postcard?): Boolean {
        logI("pretreatment")

        return true
    }
}