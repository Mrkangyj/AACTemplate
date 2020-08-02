package com.kangyj.aactemplate.base

import androidx.annotation.Keep
import com.kangyj.libaac.mvvm.IRes

/**
 *
 *author Mr.kang
 *e-mail:kangyoujie@aliyun.com
 *github:https://github.com/Mrkangyj
 *date 2020/7/30 11
 *desc 接口返回数据封装
 *
 */
@Keep
class BaseRes<T> : IRes<T> {
    private var `data`: T? = null
    private var code: String? = null
    private var msg: String? = null
    private var version: String? = null

    override fun getResult(): T {
        return data!!
    }

    override fun getVersion(): String {
        return version!!
    }

    override fun getMsg(): String {
        return msg!!
    }

    override fun getCode(): String {
        return code!!
    }

}