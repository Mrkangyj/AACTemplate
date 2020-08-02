package com.kangyj.aactemplate.ui.home.ui.home

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.kangyj.aactemplate.R
import com.kangyj.libaac.base.BaseFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment<HomeViewModel, ViewDataBinding>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun getReplaceView(): View {
        return layout_home
    }

    override fun init(savedInstanceState: Bundle?) {
        mViewModel.onStart()
        mViewModel.result.observe(viewLifecycleOwner, Observer {
            text_home.text = it
        })
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {
        mViewModel.refreshData()
    }
}