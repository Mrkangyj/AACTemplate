package com.kangyj.aactemplate.ui.home.ui.notifications

import androidx.annotation.Keep
import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/31 16
 *desc
 *
 */
@Keep
class NotificationsData : MultiItemEntity {
//    var content: String? = null
//    var author: String? = null
    var imageUrl: String? = null
    var imageSize: String? = null
    var imageFileLength: String? = null

    override val itemType: Int
        get() = when (imageSize) {
            "1920x1080" -> type_1
            else -> type_2
        }

    companion object {
        //模拟两种布局
        const val type_1 = 1000
        const val type_2 = 2000
    }


}

