package com.dyp.common.mvvm

import android.content.Intent
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.dyp.test.common.R
import com.quvii.qvmvvm.core.base.activity.KtxBaseVMActivity

abstract class BaseVMActivity<T : ViewBinding> : KtxBaseVMActivity<T>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun getStatusBarColor(): Int {
        return R.color.colorPrimary
    }

    override fun showResult(code: Int) {
        showMessage("result: $code")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
        ARouter.getInstance().inject(this)
    }
}