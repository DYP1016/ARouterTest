package com.dyp.main.ui

import android.content.Intent
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyp.common.base.logD
import com.dyp.common.base.logE
import com.dyp.common.mvvm.BaseVMActivity
import com.dyp.common.route.RouteCenter
import com.dyp.core.config.AppConst
import com.dyp.core.export.entity.AccountInfo
import com.dyp.test.module_main.R
import com.dyp.test.module_main.databinding.MainActivityMainBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

@Route(path = AppConst.Router.Main.A_MAIN)
class MainActivity : BaseVMActivity<MainActivityMainBinding>() {
    private val viewModel = MainViewModel()

    @Autowired(name = AccountInfo.NAME)
    lateinit var accountInfo: AccountInfo

    @Autowired(name = AppConst.ID.ACCOUNT_ID)
    @JvmField
    var accountId: Int = 0

    private val flAccount by lazy {
        RouteCenter.getFragment(AppConst.Router.Account.F_ACCOUNT_INFO)
    }

    override fun getViewBinding(): MainActivityMainBinding {
        return MainActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_content, flAccount)
            commit()
        }
    }

    override fun initData() {
        logE("info: $accountInfo id: $accountId")
    }


    override fun startObserve(): KtxBaseViewModel {
        return viewModel
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        logE("info: $accountInfo id: $accountId")
    }
}