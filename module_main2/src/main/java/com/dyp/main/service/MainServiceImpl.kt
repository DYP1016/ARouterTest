package com.dyp.main.service

import android.annotation.SuppressLint
import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyp.common.base.logD
import com.dyp.common.base.logI
import com.dyp.core.config.AppConst
import com.dyp.core.export.service.main.MainService
import com.quvii.qvlib.util.QvToastUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

@Route(path = AppConst.Router.Main.S_MAIN)
class MainServiceImpl : MainService {
    override fun test(name: String) {
        QvToastUtil.showL("hello, $name")
    }

    @SuppressLint("CheckResult")
    override fun test2(input: Int, callBack: () -> Int) {
        logI("main 2 start")
        Observable.timer(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { QvToastUtil.showL("test2: $input ${callBack()}") }
    }

    override fun init(context: Context?) {
        logD("init")
    }
}