package com.kangyj.aactemplate.ui.home.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kangyj.aactemplate.R
import com.kangyj.libaac.base.BaseListFragment
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.recyclerView
import kotlinx.android.synthetic.main.fragment_dashboard.smartRefreshLayout

class DashboardFragment :
    BaseListFragment<DashboardViewModel, ViewDataBinding, DashbordAdapter, DashboardData>() {


    override fun getLayoutId(): Int {
        return R.layout.fragment_dashboard
    }

    override fun getReplaceView(): View {
        return dashbord_layout
    }

    override fun init(savedInstanceState: Bundle?) {

        mViewModel.getMusicList(1)

    }

    override fun loadPageListData(pageNo: Int) {
        mViewModel.getMusicList(pageNo)
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
        adapter = DashbordAdapter()
    }


}