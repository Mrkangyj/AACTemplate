package com.kangyj.aactemplate.ui.home.ui.dashboard

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.databinding.ItemDashbordBinding
import com.kangyj.libaac.base.BaseAdapter
import com.kangyj.libaac.view.baseviewholder.HulkViewHolder
import java.util.*


/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/30 13
 *desc
 *
 */
class DashbordAdapter : BaseAdapter<DashboardData>(R.layout.item_dashbord, ArrayList()) {


    override fun onItemViewHolderCreated(viewHolder: HulkViewHolder, viewType: Int) {
        DataBindingUtil.bind<ItemDashbordBinding>(viewHolder.itemView)
    }

    override fun convert(holder: HulkViewHolder, item: DashboardData) {

        val itemListBinding = DataBindingUtil.getBinding<ItemDashbordBinding>(holder.itemView)
        if (itemListBinding != null) {
            itemListBinding.dashbordData = item
        }
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
            Log.i("Mr.kang", "loadImage: $url+走到这里了")
        }
    }
}

