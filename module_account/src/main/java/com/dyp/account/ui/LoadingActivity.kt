package com.dyp.account.ui

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.dyp.common.mvvm.BaseVMActivity
import com.dyp.core.config.AppConst
import com.dyp.core.export.entity.AccountInfo
import com.dyp.core.export.service.main.MainService
import com.dyp.test.module_account.databinding.AccountActivityLoadingBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

class LoadingActivity : BaseVMActivity<AccountActivityLoadingBinding>() {
    private val viewModel = LoadingViewModel()

    @Autowired
    @JvmField
    var mainService: MainService? = null

    override fun getViewBinding(): AccountActivityLoadingBinding {
        return AccountActivityLoadingBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.tvHint.setOnClickListener {
            ARouter.getInstance()
                .build(AppConst.Router.Main.A_MAIN)
                .withInt(AppConst.ID.ACCOUNT_ID, 20)
                .withObject(AccountInfo.NAME, AccountInfo(20, "qvtest"))
                .navigation(this)

            ARouter.getInstance()
                .build(AppConst.Router.Main.A_MAIN)
                .withInt(AppConst.ID.ACCOUNT_ID, 21)
                .withObject(AccountInfo.NAME, AccountInfo(21, "qvtest2"))
                .navigation(this)
        }

        binding.tvHint.setOnLongClickListener {
            mainService?.test2(123) {
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