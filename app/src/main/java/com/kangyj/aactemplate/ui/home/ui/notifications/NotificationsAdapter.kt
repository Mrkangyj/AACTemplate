package com.kangyj.aactemplate.ui.home.ui.notifications

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ItemNotificationsTypeOneBinding
import com.kangyj.aactemplate.databinding.ItemNotificationsTypeSecondBinding
import com.kangyj.libaac.base.BaseAdapter
import com.kangyj.libaac.base.BaseMultiAdapter
import com.kangyj.libaac.view.baseviewholder.HulkViewHolder
import java.util.ArrayList

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/31 16
 *desc
 *
 */
class NotificationsAdapter : BaseMultiAdapter<NotificationsData>(ArrayList()) {

    override fun onItemViewHolderCreated(viewHolder: HulkViewHolder, viewType: Int) {
        when (viewType) {
            NotificationsData.type_1 -> {
                DataBindingUtil.bind<ItemNotificationsTypeSecondBinding>(viewHolder.itemView)
            }
            NotificationsData.type_2 -> {
                DataBindingUtil.bind<ItemNotificationsTypeOneBinding>(viewHolder.itemView)
            }
        }

    }

    override fun convert(holder: HulkViewHolder, item: NotificationsData) {
        when (item.itemType) {
            NotificationsData.type_1 -> {
                val itemListBinding = holder.getBinding<ItemNotificationsTypeSecondBinding>()
//                    DataBindingUtil.getBinding<ItemNotificationsTypeSecondBinding>(holder.itemView)
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
            NotificationsData.type_2 -> {
                val itemListBinding = holder.getBinding<ItemNotificationsTypeOneBinding>()
//                    DataBindingUtil.getBinding<ItemNotificationsTypeOneBinding>(holder.itemView)
                if (itemListBinding != null) {
                    itemListBinding.multiListData = item
                }
            }
        }
    }

    override fun addItemType() {
        addItemType(NotificationsData.type_1, R.layout.item_notifications_type_second)
        addItemType(NotificationsData.type_2, R.layout.item_notifications_type_one)
    }


    companion object {
        @BindingAdapter("app:imgUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.load_error)
                .into(imageView)
        }
    }
}