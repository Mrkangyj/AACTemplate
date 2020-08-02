package com.kangyj.libaac.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author Mr.kang
 * @date 2020/3/16.
 * module：
 * description：
 */
abstract class AACApplication : Application() {
    abstract fun initAACConfig() //初始化配置参数
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

    }

    override fun onCreate() {
        super.onCreate()
        initAACConfig()
        //ARouter的初始化
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }

}