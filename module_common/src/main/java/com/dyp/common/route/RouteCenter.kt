package com.dyp.common.route

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author Alwyn
 * @Date 2020/10/23
 * @Description
 */
object RouteCenter {
    fun navigate(path: String, bundle: Bundle? = null): Any? {
        val build = ARouter.getInstance().build(path)
        return if (bundle == null) build.navigation() else build.with(bundle).navigation()
    }

    fun getFragment(path: String): Fragment {
        return ARouter.getInstance().build(path).navigation() as Fragment
    }
}