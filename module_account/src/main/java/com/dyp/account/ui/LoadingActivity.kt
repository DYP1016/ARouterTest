package com.dyp.account.ui

import android.os.Bundle
import com.dyp.common.mvvm.BaseVMActivity
import com.dyp.common.route.RouteCenter
import com.dyp.core.config.AppConst
import com.dyp.test.module_account.databinding.ActivityLoadingBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

class LoadingActivity : BaseVMActivity<ActivityLoadingBinding>() {
    private val viewModel = LoadingViewModel()

    override fun getViewBinding(): ActivityLoadingBinding {
        return ActivityLoadingBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.tvHint.setOnClickListener { RouteCenter.navigate(AppConst.Router.Main.A_MAIN) }
    }

    override fun initData() {

    }

    override fun startObserve(): KtxBaseViewModel {

        return viewModel
    }
}