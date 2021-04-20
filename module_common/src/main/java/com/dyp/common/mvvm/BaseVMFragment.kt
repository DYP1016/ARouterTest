package com.dyp.common.mvvm

import androidx.viewbinding.ViewBinding
import com.quvii.qvmvvm.core.base.fragment.KtxBaseVMFragment

abstract class BaseVMFragment<T : ViewBinding> : KtxBaseVMFragment<T>() {

    override fun showResult(code: Int) {
        showMessage("result: $code")
    }
}