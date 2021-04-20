package com.dyp.common.mvvm

import androidx.lifecycle.viewModelScope
import com.dyp.common.base.App
import com.dyp.common.base.logE
import com.dyp.common.base.retSuccess
import com.dyp.common.entity.QvResult
import com.quvii.qvmvvm.core.base.KtxBaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


open class BaseViewModel : KtxBaseViewModel() {
    /**
     *  创建协程作用域, 可自动产生加载框, 对异常进行捕获, 避免出现异常时App崩溃,
     *  由于使用的默认选择, 默认会在子线程中执行, 不可在方法体中直接调用UI操作
     */
    fun launch(showLoading: Boolean = true, block: suspend CoroutineScope.() -> Unit): Job {
        return viewModelScope.launch {
            if (showLoading) {
                showOrHideLoading(true)
            }

            try {
                block()
            } catch (e: Exception) {
                logE(e)
                showMessage("Fail: $e")
            }
            if (showLoading) {
                showOrHideLoading(false)
            }
        }
    }

    protected open fun setInfo(
        function: suspend () -> Int,
        isShowLoading: Boolean = true,
        onSuccess: () -> Unit
    ): Job {
        return launch(isShowLoading) {
            val ret = function()
            if (ret.retSuccess()) {
                onSuccess()
            } else {
                showResult(ret)
            }
        }
    }

    protected open fun <T> getInfo(
        function: suspend () -> QvResult<T>,
        onSuccess: (result: T) -> Unit
    ): Job {
        return launch {
            val ret = function()
            if (ret.retSuccess()) {
                val result = ret.result
                if (result != null) {
                    onSuccess(result)
                } else {
                    showResult(-1)
                }
            } else {
                showResult(ret.code)
            }
        }
    }

    protected fun getString(res: Int): String {
        return App.getContext().getString(res)
    }
}