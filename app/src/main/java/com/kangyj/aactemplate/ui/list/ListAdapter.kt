package com.kangyj.aactemplate.ui.list

import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ItemListBinding
import com.kangyj.libaac.base.BaseAdapter
import com.kangyj.libaac.view.baseviewholder.HulkViewHolder
import java.util.ArrayList

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/30 13
 *desc
 *
 */
class ListAdapter : BaseAdapter<ListData>(R.layout.item_list, ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: HulkViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemListBinding>(viewHolder.itemView)
    }

    override fun convert(holder: HulkViewHolder, item: ListData) {
        val itemListBinding = DataBindingUtil.getBinding<ItemListBinding>(holder.itemView)
        if (itemListBinding != null) {
            itemListBinding.listData=item
        }
    }

}