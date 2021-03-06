package com.kangyj.libaac.view

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Mr.kang
 * @date 2020/3/13.
 * module：
 * description：变化view辅助类用于增删view
 */
class VaryViewHelper(
    /**
     * 需替换的布局view
     * @return
     */
    //要替换的view 必须是ViewGroup的相关继承类
    override val replaceView: View
) : IVaryViewHelper {

    //替换view的夫view容器
    private var parentView: ViewGroup? = null
    //要替换的view的下角标
    private var viewIndex = 0
    //夫容器的布局参数
    private var params: ViewGroup.LayoutParams? = null
    //当前显示的view
    private var mcurrentView: View? = null

    /**
     * 当前显示的view
     * @return
     */
    override val currentView: View
        get() = currentView


    /**
     * 恢复到需替换的布局view
     */
    override fun restoreView() {
        showView(replaceView)
    }

    /**
     * 设置要展示的view
     * @param view
     */
    override fun showView(view: View) {
        if (parentView == null) {
            init()
        }
        mcurrentView = view
        if (parentView!!.getChildAt(viewIndex) != view) {
            if (view.parent != null) {
                val parent: ViewGroup = view.parent as ViewGroup
                parent.removeView(view)
            }
            parentView!!.removeViewAt(viewIndex)
            parentView!!.addView(view, viewIndex, params)
        }
        //java.lang.IllegalStateException:
        // Views added to a FragmentContainerView must be associated with a Fragment.
        // View androidx.constraintlayout.widget.ConstraintLayout
        // is not associated with a Fragment.
    }

    /**
     * 设置要加载的布局layoutId
     * @param layoutId
     * @return
     */
    override fun inflate(layoutId: Int): View {
        return LayoutInflater.from(replaceView.context).inflate(layoutId, null, false)
    }

    /**
     * 上下文
     * @return
     */
    override val context: Context
        get() = replaceView.context

    private fun init() {
        params = replaceView.layoutParams
        parentView =
            if (replaceView.parent != null) {
                replaceView.parent as ViewGroup
            } else {
                replaceView.rootView.findViewById(R.id.content)
            }
        val count = parentView!!.childCount
        for (index in 0 until count) {
            if (replaceView === parentView!!.getChildAt(index)) {
                viewIndex = index
                break
            }
        }
        mcurrentView = replaceView
    }

}