package com.kangyj.aactemplate.ui.main

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.kangyj.aactemplate.ARouterUri
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.consts.AACKey
import com.kangyj.aactemplate.dialog.CustomDialogFragment
import com.kangyj.aactemplate.utils.ActionBarUtils
import com.kangyj.libaac.base.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity<MainModel, ViewDataBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getReplaceView(): View {
        return main_layout
    }

    override fun init(savedInstanceState: Bundle?) {
        ActionBarUtils.setCenterTitleText(toolbar, "AAC项目展示")

        //list展示
        tv_list.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.ListActivity).navigation()

        }
        //navigation
        tv_navigation.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.HomeActivity).navigation()
        }

        //dialog提示
        tv_dialog.setOnClickListener {
            showDialog()
        }
        //多布局展示
        tv_multi.setOnClickListener {
            ARouter.getInstance().build(ARouterUri.MultiActivity).navigation()
        }

    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }

    private fun showDialog() {
        val dialogFragment = CustomDialogFragment()
        val bundle = Bundle()
        bundle.putString(AACKey.CommonTitle, "提示标题")
        bundle.putString(AACKey.CommonDesc, "提示内容")
        bundle.putString(AACKey.CommonLeft, "取消")
        bundle.putString(AACKey.CommonRight, "确定")
        bundle.putString(AACKey.CommonRemind, "不再提醒")
        bundle.putBoolean(AACKey.CommonExternalArea, true)
        dialogFragment.arguments = bundle
        dialogFragment.setOnLeftRightClickListener(object :
            CustomDialogFragment.onLeftRightClickListener {
            override fun onLeftClick(isRemind: Boolean) {
                showToast("点击了左边按钮，是否不再提醒$isRemind")
            }

            override fun onRightClick(isRemind: Boolean) {
                showToast("点击了右边按钮，是否不再提醒$isRemind")
            }
        })
        dialogFragment.show(supportFragmentManager, CustomDialogFragment::class.java.name)
    }
}