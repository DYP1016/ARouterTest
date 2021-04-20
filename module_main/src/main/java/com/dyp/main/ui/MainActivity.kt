package com.dyp.main.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyp.common.mvvm.BaseVMActivity
import com.dyp.core.config.AppConst
import com.dyp.test.module_main.databinding.ActivityMainBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

@Route(path = AppConst.Router.Main.A_MAIN)
class MainActivity : BaseVMActivity<ActivityMainBinding>() {
    private val viewModel = MainViewModel()

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun initData() {

    }


    override fun startObserve(): KtxBaseViewModel {

        return viewModel
    }
}