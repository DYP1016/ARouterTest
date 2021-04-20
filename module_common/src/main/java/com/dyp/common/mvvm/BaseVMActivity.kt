package com.dyp.common.mvvm

import androidx.viewbinding.ViewBinding
import com.dyp.test.common.R
import com.quvii.qvmvvm.core.base.activity.KtxBaseVMActivity

abstract class BaseVMActivity<T : ViewBinding> : KtxBaseVMActivity<T>() {
    override fun getStatusBarColor(): Int {
        return R.color.colorPrimary
    }

    override fun showResult(code: Int) {
        showMessage("result: $code")
    }
}