package com.kangyj.aactemplate.ui.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kangyj.aactemplate.ARouterUri
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ActivityListBinding
import com.kangyj.aactemplate.utils.ActionBarUtils
import com.kangyj.libaac.base.BaseListActivity
import com.kangyj.libaac.utils.LogUtils
import com.kangyj.libaac.utils.ToastUtils
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.toolbar.*

@Route(path = ARouterUri.ListActivity)
class ListActivity : BaseListActivity<ListViewModel, ActivityListBinding, ListAdapter, ListData>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_list
    }

    override fun getReplaceView(): View {
        return smartRefreshLayout
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setCenterTitleText(toolbar, "List数据展示界面")
        //是否可以加载更多
        //setLoadMoreEnable(false)
        //是否可以刷新
        //setRefreshEnable(false)
        //请求接口
        mViewModel.cityList(1)
    }

    /**
     * 加载更多数据
     */
    override fun loadPageListData(pageNo: Int) {
        LogUtils.d("======pageNo=====$pageNo")
        mViewModel.cityList(pageNo)
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout {
        return smartRefreshLayout
    }

    override fun getRecyclerView(): RecyclerView {
        return recyclerView
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this)
    }

    override fun getAdapter() {
        adapter = ListAdapter()
        adapter!!.setOnItemClickListener { adapter, view, position ->
            var any: ListData = adapter.data[position] as ListData
            ToastUtils.showShortToastSafe(this, any.name)
        }
    }
}