package com.dyp.common.mvvm

import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.dyp.test.common.R
import com.quvii.qvmvvm.core.base.activity.KtxBaseVMActivity

abstract class BaseVMActivity<T : ViewBinding> : KtxBaseVMActivity<T>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
    }

    override fun getStatusBarColor(): Int {
        return R.color.colorPrimary
    }

    override fun showResult(code: Int) {
        showMessage("result: $code")
    }
}