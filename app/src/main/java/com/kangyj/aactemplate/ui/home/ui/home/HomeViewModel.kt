package com.kangyj.aactemplate.ui.home.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kangyj.aactemplate.api.ApiService
import com.kangyj.libaac.mvvm.BaseViewModel

class HomeViewModel : BaseViewModel<ApiService>() {


    var result = MutableLiveData<String>()

    public override fun onStart() {
        result.value = "This is home fragment"
    }

    public fun refreshData() {
        result.value = "刷新得到新数据"
        //恢复原先
        viewChange.restore.call()
    }
}