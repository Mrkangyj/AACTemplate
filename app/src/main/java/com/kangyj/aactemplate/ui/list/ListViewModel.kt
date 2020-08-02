package com.kangyj.aactemplate.ui.list

import com.kangyj.aactemplate.api.ApiService
import com.kangyj.libaac.em.RequestDisplay
import com.kangyj.libaac.mvvm.BaseListViewModel
import com.kangyj.libaac.mvvm.BaseViewModel

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/30
 *desc
 *
 */
class ListViewModel : BaseListViewModel<ApiService>() {
    override fun onStart() {

    }


    fun cityList(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getCityList()
            },
            //重试
            reTry = {
                //调用重试的方法
                cityList(pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

}