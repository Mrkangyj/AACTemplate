package com.kangyj.aactemplate.ui.home.ui.notifications

import com.kangyj.aactemplate.api.ApiService
import com.kangyj.libaac.em.RequestDisplay
import com.kangyj.libaac.mvvm.BaseListViewModel

class NotificationsViewModel : BaseListViewModel<ApiService>() {
    override fun onStart() {
    }

    fun dailyWordList(count: Int, pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().dailyWordList(count, pageNo)
            },
            //重试
            reTry = {
                //调用重试的方法
                dailyWordList(count, pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

    fun getWelfareList(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getWelfareList()
            },
            //重试
            reTry = {
                //调用重试的方法
                getWelfareList(pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

}