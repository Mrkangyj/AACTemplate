package com.kangyj.aactemplate.api

import com.kangyj.aactemplate.base.BaseRes
import com.kangyj.aactemplate.ui.home.ui.dashboard.DashboardData
import com.kangyj.aactemplate.ui.home.ui.notifications.NotificationsData
import com.kangyj.aactemplate.ui.list.ListData
import com.kangyj.aactemplate.ui.multi.MultiListData
import retrofit2.http.*

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/30
 *desc api数据接口
 *
 */
interface ApiService {

    //城市列表
    @GET("api/address/list")
    suspend fun getCityList(): BaseRes<List<ListData>>

    //每日音乐
    @POST("api/news/list?typeId=509&")
    suspend fun getMusicList(@Query("page") page: Int): BaseRes<List<DashboardData>>

    //每日精美句子
    @FormUrlEncoded
    @POST("api/daily_word/recommend")
    suspend fun dailyWordList(
        @Field("count") count: Int,
        @Field("page") page: Int
    ): BaseRes<List<DashboardData>>

    //福利图片
    @GET("api/image/girl/list/random")
    suspend fun getWelfareList(): BaseRes<List<NotificationsData>>

    @GET("api/address/list")
    suspend fun getMultiList(): BaseRes<List<MultiListData>>
}