package com.dyp.account.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.dyp.common.mvvm.BaseVMActivity
import com.dyp.common.route.RouteCenter
import com.dyp.core.config.AppConst
import com.dyp.core.export.service.main.MainService
import com.dyp.test.module_account.databinding.ActivityLoadingBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

class LoadingActivity : BaseVMActivity<ActivityLoadingBinding>() {
    private val viewModel = LoadingViewModel()

    @Autowired
    lateinit var mainService: MainService

    override fun getViewBinding(): ActivityLoadingBinding {
        return ActivityLoadingBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.tvHint.setOnClickListener { RouteCenter.navigate(AppConst.Router.Main.A_MAIN) }

        binding.tvHint.setOnLongClickListener {
            mainService.test2(123) {
                233
            }
            true
        }
    }

    override fun initData() {

    }

    override fun startObserve(): KtxBaseViewModel {

        return viewModel
    }
}