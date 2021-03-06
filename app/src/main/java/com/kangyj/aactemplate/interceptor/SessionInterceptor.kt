package com.madreain.aachulk.interceptor

import com.kangyj.libaac.http.interceptor.IReturnCodeErrorInterceptor


/**
 * @author Mr.kang
 * @date 2019/3/4.
 * module：
 * description：returnCode返回session_100 拦截处理
 */
class SessionInterceptor : IReturnCodeErrorInterceptor {
    //和接口定义互踢的相关参数返回，然后在doWork方法进行跳转
    override fun intercept(returnCode: String?): Boolean {
        return "-100" == returnCode
    }

    override fun doWork(returnCode: String?, msg: String?) {

    }

}