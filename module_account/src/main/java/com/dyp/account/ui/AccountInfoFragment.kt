package com.dyp.account.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyp.common.mvvm.BaseVMFragment
import com.dyp.core.config.AppConst
import com.dyp.test.module_account.databinding.AccountFragmentAccountInfoBinding
import com.quvii.qvmvvm.core.base.KtxBaseViewModel

@Route(path = AppConst.Router.Account.F_ACCOUNT_INFO)
class AccountInfoFragment : BaseVMFragment<AccountFragmentAccountInfoBinding>() {
    private val viewModel = AccountInfoViewModel()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): AccountFragmentAccountInfoBinding {
        return AccountFragmentAccountInfoBinding.inflate(inflater, container, false)
    }

    override fun initView(savedInstanceState: Bundle?) {

    }

    override fun startObserve(): KtxBaseViewModel {
        return viewModel
    }
}