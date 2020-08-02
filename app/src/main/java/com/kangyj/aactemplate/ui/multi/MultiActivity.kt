package com.kangyj.aactemplate.ui.multi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.facade.annotation.Route
import com.kangyj.aactemplate.ARouterUri
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ActivityMultiBinding
import com.kangyj.aactemplate.ui.home.ui.notifications.NotificationsData
import com.kangyj.aactemplate.utils.ActionBarUtils
import com.kangyj.libaac.base.BaseListActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_multi.*
import kotlinx.android.synthetic.main.toolbar.*

@Route(path = ARouterUri.MultiActivity)
class MultiActivity :
    BaseListActivity<MultiViewModel, ActivityMultiBinding, MultiAdapter, MultiListData>() {


    override fun getLayoutId(): Int {
        return R.layout.activity_multi;
    }

    override fun getReplaceView(): View {
        return activity_multi
    }

    override fun init(savedInstanceState: Bundle?) {
        //ActionBar相关设置
        ActionBarUtils.setSupportActionBarWithBack(toolbar, null, View.OnClickListener {
            onBackPressed()
        })
        ActionBarUtils.setCenterTitleText(toolbar, "多布局的展示")
        mViewModel.getMultiList(1)

    }

    /**
     * list相关方法
     */
    override fun loadPageListData(pageNo: Int) {
        mViewModel.getMultiList(2)
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
        adapter = MultiAdapter()
    }
}
