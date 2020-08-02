package com.kangyj.aactemplate.ui.home.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kangyj.aactemplate.api.ApiService
import com.kangyj.libaac.em.RequestDisplay
import com.kangyj.libaac.mvvm.BaseListViewModel
import com.kangyj.libaac.mvvm.BaseViewModel

class DashboardViewModel : BaseListViewModel<ApiService>() {

    override fun onStart() {

    }

    fun getMusicList(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getMusicList(pageNo)
            },
            //重试
            reTry = {
                //调用重试的方法
                getMusicList(pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }
}