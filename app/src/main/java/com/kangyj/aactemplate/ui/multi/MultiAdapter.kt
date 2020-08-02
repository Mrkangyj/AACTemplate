package com.kangyj.aactemplate.ui.multi

import androidx.databinding.DataBindingUtil
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ItemActivityMulti2Binding
import com.kangyj.aactemplate.databinding.ItemActivityMultiBinding
import com.kangyj.libaac.base.BaseMultiAdapter
import com.kangyj.libaac.view.baseviewholder.HulkViewHolder
import java.util.ArrayList

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/8/1 21
 *desc
 *
 */
class MultiAdapter : BaseMultiAdapter<MultiListData>(ArrayList()) {


    override fun onItemViewHolderCreated(viewHolder: HulkViewHolder, viewType: Int) {
        when (viewType) {
            MultiListData.type_1 -> {
                DataBindingUtil.bind<ItemActivityMultiBinding>(viewHolder.itemView)
            }
            MultiListData.type_2 -> {
                DataBindingUtil.bind<ItemActivityMulti2Binding>(viewHolder.itemView)
            }
        }
    }

    /**
     * 布局
     */
    override fun convert(helper: HulkViewHolder, item: MultiListData) {
        when (item.itemType) {
            MultiListData.type_1 -> {
                val itemListBinding = helper.getBinding<ItemActivityMultiBinding>()
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
            MultiListData.type_2 -> {
                val itemListBinding = helper.getBinding<ItemActivityMulti2Binding>()
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
        }
    }

    override fun addItemType() {
        addItemType(MultiListData.type_1, R.layout.item_activity_multi)
        addItemType(MultiListData.type_2, R.layout.item_activity_multi2)
    }


}