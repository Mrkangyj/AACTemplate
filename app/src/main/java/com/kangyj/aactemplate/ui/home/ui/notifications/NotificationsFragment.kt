package com.kangyj.aactemplate.ui.home.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kangyj.aactemplate.R
import com.kangyj.libaac.base.BaseListFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment :
    BaseListFragment<NotificationsViewModel, ViewDataBinding, NotificationsAdapter, NotificationsData>() {
    override fun getLayoutId(): Int {
        return R.layout.fragment_notifications
    }

    override fun getReplaceView(): View {
        return notifications_layout
    }

    override fun init(savedInstanceState: Bundle?) {
//        mViewModel.dailyWordList(10, 1)
        mViewModel.getWelfareList(1)
    }

    override fun loadPageListData(pageNo: Int) {
//        mViewModel.dailyWordList(10, pageNo)
        mViewModel.getWelfareList(pageNo)
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return smartRefreshLayout
    }

    override fun getRecyclerView(): RecyclerView? {
        return recyclerView
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return LinearLayoutManager(activity)
    }

    override fun getAdapter() {
        adapter = NotificationsAdapter()
    }


}