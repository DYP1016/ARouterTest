package com.dyp.common.base

import android.app.Activity
import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dyp.test.common.BuildConfig
import com.dyp.test.common.R
import com.quvii.qvlib.QvLibCore
import com.quvii.qvlib.base.QvBaseApp
import com.quvii.qvlib.util.QvEncryptKeyStoreUtil
import com.quvii.qvlib.util.QvPermissionUtils

class App : QvBaseApp() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)

        initQvLib()
        logI("init")
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