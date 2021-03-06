package com.dyp.common.base

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.dyp.common.init.InitManager
import com.dyp.test.common.BuildConfig
import com.dyp.test.common.R
import com.quvii.qvlib.QvLibCore
import com.quvii.qvlib.base.QvBaseApp
import com.quvii.qvlib.util.QvEncryptKeyStoreUtil
import com.quvii.qvlib.util.QvPermissionUtils

class App : QvBaseApp() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        val start = System.currentTimeMillis()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        initQvLib()
        logI("init: ${System.currentTimeMillis() - start}ms")
    }

    override fun onActivityStarted(p0: Activity?) {

    }

    override fun onActivityStopped(p0: Activity?) {

    }

    private fun initQvLib() {
        QvEncryptKeyStoreUtil.initKeyStore()
        QvLibCore.getInstance().init("test")

        QvPermissionUtils.init(
            R.string.key_permission_title_permission_failed,
            R.string.key_permission_message_permission_failed,
            R.string.key_permission_resume,
            R.string.key_cancel,
            R.string.key_setting
        )
    }


    companion object {
        fun getContext(): Application {
            return getInstance()
        }
    }
}