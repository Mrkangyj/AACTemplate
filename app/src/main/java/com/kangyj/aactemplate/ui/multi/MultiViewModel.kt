package com.kangyj.aactemplate.ui.multi

import com.kangyj.aactemplate.api.ApiService
import com.kangyj.libaac.em.RequestDisplay
import com.kangyj.libaac.mvvm.BaseListViewModel

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/8/1 21
 *desc
 *
 */
class MultiViewModel : BaseListViewModel<ApiService>() {


    public override fun onStart() {

    }

    fun getMultiList(pageNo: Int) {
        launchOnlyresult(
            //调用接口方法
            block = {
                getApiService().getMultiList()
            },
            //重试
            reTry = {
                //调用重试的方法
                getMultiList(pageNo)
            },
            //成功
            success = {
                //成功回调
            }, type = RequestDisplay.REPLACE, pageNo = pageNo
        )
    }

}
