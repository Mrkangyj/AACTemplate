package com.kangyj.libaac.base

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.kangyj.libaac.view.baseviewholder.HulkViewHolder

/**
 * @author Mr.kang
 * @date 2020/3/23.
 * module：继承BaseQuickAdapter，自定义通用方法
 * description：
 */
abstract class BaseMultiAdapter<T : MultiItemEntity>(data: MutableList<T>) :

    BaseMultiItemQuickAdapter<T, HulkViewHolder>(data) {

    abstract fun addItemType()

    init {
        addItemType()
    }

    open fun clearData() {
        data.clear()
        notifyDataSetChanged()
    }

}