package com.kangyj.aactemplate.dialog

import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import androidx.databinding.ViewDataBinding
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.consts.AACKey
import com.kangyj.aactemplate.utils.DrawableUtils
import com.kangyj.libaac.base.BaseDialogFragment
import com.kangyj.libaac.utils.StringUtils
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_dialog.*

class CustomDialogFragment : BaseDialogFragment<DialogViewModel, ViewDataBinding>() {

    var title: String? = null
    var desc: String? = null
    var left: String? = null
    var right: String? = null
    var remind: String? = null
    //false可消失
    var externalArea = false
    var isRemind = false

    override fun getLayoutId(): Int {
        return R.layout.fragment_dialog
    }

    override fun getReplaceView(): View {
        return fl_parent
    }

    override fun onStart() {
        super.onStart()
        // 下面这些设置必须在此方法(onStart())中才有效
        val window = dialog!!.window
        // 如果不设置这句代码, 那么弹框就会与四边都有一定的距离
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        // 设置动画
        window?.setWindowAnimations(R.style.CommonDialog)
        val params = window?.attributes
        //背景透明
        params!!.dimAmount = 0.4f
        params.gravity = Gravity.CENTER
        // 如果不设置宽度,那么即使你在布局中设置宽度为 match_parent 也不会起作用
        params.width = resources.displayMetrics.widthPixels
        window.attributes = params
    }

    override fun init(savedInstanceState: Bundle?) {
        // 去掉默认的标题
        dialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //数据的获取
        //数据的获取
        val bundle = arguments
        if (bundle != null) {
            title = bundle.getString(AACKey.CommonTitle)
            desc = bundle.getString(AACKey.CommonDesc)
            left = bundle.getString(AACKey.CommonLeft)
            right = bundle.getString(AACKey.CommonRight)
            remind = bundle.getString(AACKey.CommonRemind)
            externalArea = bundle.getBoolean(AACKey.CommonExternalArea)
        }
        //样式的展示
        // 标题
        if (StringUtils.isEmpty(title)) {
            tv_title.visibility = View.GONE
        } else {
            tv_title.text = title
        }
        //内容
        if (StringUtils.isEmpty(desc)) {
            tv_desc.visibility = View.GONE
        } else {
            tv_desc.text = desc
        }
        //左边隐藏
        if (StringUtils.isEmpty(left)) {
            tv_left.visibility = View.GONE
            v_vertical.visibility = View.GONE
        } else {
            tv_left.text = left
        }
        //右边隐藏
        if (StringUtils.isEmpty(right)) {
            tv_right.visibility = View.GONE
            v_vertical.visibility = View.GONE
        } else {
            tv_right.text = right
        }
        //提醒
        if (StringUtils.isEmpty(remind)) {
            tv_remind.visibility = View.GONE
        } else {
            tv_remind.text = remind
        }
        //点击外部区域是否消失
        if (externalArea) {
            dialog!!.setCanceledOnTouchOutside(false)
        } else {
            dialog!!.setCanceledOnTouchOutside(true)
        }
        /**
         * 相关监听事件
         */
        tv_left.setOnClickListener {
            if (monLeftRightClickListener != null) {
                monLeftRightClickListener!!.onLeftClick(isRemind)
            }
            dismiss()
        }
        tv_right.setOnClickListener {
            if (monLeftRightClickListener != null) {
                monLeftRightClickListener!!.onRightClick(isRemind)
            }
            dismiss()
        }
        tv_remind.setOnClickListener {
            //未选中到选中
            if (!isRemind) {
                DrawableUtils.setDrawableLeft(
                    tv_remind,
                    requireContext().resources.getDrawable(R.mipmap.ic_select)
                )
            } else {
                DrawableUtils.setDrawableLeft(
                    tv_remind,
                    requireContext().resources.getDrawable(R.mipmap.ic_unselect)
                )
            }
            isRemind = !isRemind
        }
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {

    }

    private var monLeftRightClickListener: onLeftRightClickListener? = null

    interface onLeftRightClickListener {
        fun onLeftClick(isRemind: Boolean)
        fun onRightClick(isRemind: Boolean)
    }

    fun setOnLeftRightClickListener(onLeftRightClickListener: onLeftRightClickListener?) {
        this.monLeftRightClickListener = onLeftRightClickListener
    }

}