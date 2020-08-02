# AACTemplate
AAC架构
## 基础功能

1.主项目启用dataBinding

     buildFeatures{
        dataBinding = true
    }

2.添加依赖

在project的build.grade加入

allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
        google()
        jcenter()
    }
}

在主项目app的build.grade加入

api  'com.github.Mrkangyj:AACTemplate:1.0.0'

3.继承AACApplication，配置相关配置项
  
    HulkConfig.builder() //这里只需要选择设置一个
            .setRetSuccess(BuildConfig.CODE_SUCCESS)
            .setBaseUrl(BuildConfig.BASE_URL)
            .setLogOpen(BuildConfig.OPEN_LOG)
            .setArouterOpen(BuildConfig.OPEN_AROUTER)
            .setEventBusOpen(BuildConfig.OPEN_EVENTBUS)
            .addOkHttpInterceptor(RequestHeaderInterceptor()) //请求头拦截器
            .addOkHttpInterceptor(
                BuildConfig.OPEN_LOG,
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            ) //okhttp请求日志开关+消息拦截器.md
            .addRetCodeInterceptors(SessionInterceptor()) // returnCode非正常态拦截器
            .setRetrofit(
                ApiClient.instance!!.getRetrofit(
                    ApiClient.instance!!.getOkHttpClient(
                        HulkConfig.getOkHttpInterceptors()
                    )
                )
            )
            .build()
