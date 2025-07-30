package com.vmloft.develop.convention

/**
 * Created by lzan13 on 2024/01/25
 * 描述：依赖版本管理
 */
object VMDependencies {
    // kotlin 相关库
    // Kotlin 协同程序扩展
    const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:2.2.0"
    // 介绍 https://www.kotlincn.net/docs/reference/coroutines/coroutines-guide.html
    const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2"

    // 依赖当前平台所对应的平台库
    const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2"

    // AndroidX 库
    const val activityKtx = "androidx.activity:activity-ktx:1.8.0"
    const val appCompat = "androidx.appcompat:appcompat:1.6.1"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:1.6.2"
    const val coreKtx = "androidx.core:core-ktx:1.16.0"
    const val splashScreen = "androidx.core:core-splashscreen:1.0.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.2.1"
    const val coordinatorLayout = "androidx.coordinatorlayout:coordinatorlayout:1.2.0"
    const val localBroadcastManager = "androidx.localbroadcastmanager:localbroadcastmanager:1.1.0"
    const val datastorePreferences = "androidx.datastore:datastore-preferences:1.1.7"
    const val datastorePreferencesCore = "androidx.datastore:datastore-preferences-core:1.1.7"
    const val emoji2Emojipicker = "androidx.emoji2:emoji2-emojipicker:1.5.0"

    // google 库
    const val accompanistCoil = "com.google.accompanist:accompanist-coil:0.11.0"
    const val accompanistInsets = "com.google.accompanist:accompanist-insets:0.17.0"
    const val accompanistPager = "com.google.accompanist:accompanist-pager:0.24.3-alpha"
    const val accompanistPagerIndicators = "com.google.accompanist:accompanist-pager-indicators:0.24.3-alpha"
    const val accompanistSystemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
    const val material = "com.google.android.material:material:1.10.0"

    // Jetpack 相关
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val lifecycleLivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.2"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.9.1"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"

    // Compose
    const val activityCompose = "androidx.activity:activity-compose:1.10.1"
    const val navigationCompose = "androidx.navigation:navigation-compose:2.9.1"
    const val pagingCompose = "androidx.paging:paging-compose:3.3.6"

    const val composeBom = "androidx.compose:compose-bom:2025.06.01"
    const val composeMaterialIconsExtended = "androidx.compose.material:material-icons-extended"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeMaterial3WindowSizeClass = "androidx.compose.material3:material3-window-size-class"

    const val composeUI = "androidx.compose.ui:ui"
    const val composeUIGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUITools = "androidx.compose.ui:ui-tooling"
    const val composeUIToolsPreview = "androidx.compose.ui:ui-tooling-preview"

    // 依赖注入框架
//    // Koin for Android
//    implementation "org.koin:koin-android:2.0.1"
//    // Koin for Kotlin
//    implementation "org.koin:koin-core:2.0.1"
//    // or Koin for Lifecycle scoping
//    implementation "org.koin:koin-androidx-scope:2.0.1"
//    // or Koin for Android Architecture ViewModel
    const val koin = "org.koin:koin-androidx-viewmodel:2.0.1"

    // hilt 注解
    const val hiltAndroid = "com.google.dagger:hilt-android:2.48.1"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:2.48.1"

    // WCDB 数据库 https://github.com/Tencent/wcdb
    const val wcdb = "com.tencent.wcdb:wcdb-android:1.0.8"

    // WCDB room 代替 room-runtime https://github.com/Tencent/wcdb
    const val wcdbRoom = "com.tencent.wcdb:room:1.0.8"

    // Room 数据库
    const val roomKtx = "androidx.room:room-ktx:2.7.2"
    const val roomPaging = "androidx.room:room-paging:2.7.2"
    const val roomRuntime = "androidx.room:room-runtime:2.7.2"
    const val roomCompiler = "androidx.room:room-compiler:2.7.2"
    const val roomTesting = "androidx.room:room-testing:2.7.2"

    // Glide https://github.com/bumptech/glide
    const val glide = "com.github.bumptech.glide:glide:4.12.0"
    const val glideCompiler = "com.github.bumptech.glide:compiler:4.12.0"

    // DRouter https://github.com/didi/DRouter/wiki
    const val dRouter = "io.github.didi:drouter-api:2.4.5"

    // ZXing 二维码
    const val zXing = "com.github.bingoogolapple.BGAQRCode-Android:zxing:1.3.8"

    // 网络请求
    // OKHttp https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    const val okHttp = "com.squareup.okhttp3:okhttp:4.12.0"

    // Retrofit https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.2"

    // Gson 解析 JSON https://github.com/google/gson
    const val gson = "com.google.code.gson:gson:2.10"

    // Android消息总线，基于LiveData https://github.com/JeremyLiao/LiveEventBus
    const val liveEventBus = "io.github.jeremyliao:live-event-bus-x:1.8.0"

    const val androidSkin = "skin.support:skin-support:3.1.4"                   // skin-support 基础控件支持
    const val androidSkinDesign = "skin.support:skin-support-design:3.1.4"            // skin-support-design material design 控件支持[可选]
    const val androidSkinCardView = "skin.support:skin-support-cardview:3.1.4"          // skin-support-cardview CardView 控件支持[可选]
    const val androidSkinConstraint = "skin.support:skin-support-constraint-layout:3.1.4" // skin-support-constraint-layout ConstraintLayout 控件支持[可选]
    /**
     * 自定义控件库
     */
    // 强大 WebView 库 https://github.com/J ustson/AgentWeb
    const val agentWeb = "com.github.Justson.AgentWeb:agentweb-core:v4.1.9-androidx"

    // 轮播控件 https://github.com/zhpanvip/BannerViewPager
    const val bannerViewPager = "com.github.zhpanvip:bannerviewpager:3.5.12"

    // 动画库 https://github.com/LottieFiles/lottie-android
    const val lottie = "com.airbnb.android:lottie:6.6.0"

    // MultiType RecyclerView 多类型适配器 https://github.com/drakeet/MultiType
    const val multiType = "com.drakeet.multitype:multitype:4.2.0"

    // 输入面板切换帮助库 https://github.com/DSAppTeam/PanelSwitchHelper
    const val panelSwitchHelper = "com.github.DSAppTeam:PanelSwitchHelper:v1.5.10"

    // 沉浸式系统栏 基础依赖包 https://github.com/gyf-dev/ImmersionBar
    const val immersionbar = "com.geyifeng.immersionbar:immersionbar:3.2.2"

    // kotlin扩展（可选）
    const val immersionbarKtx = "com.geyifeng.immersionbar:immersionbar-ktx:3.2.2"

    // 下拉刷新库 https://github.com/scwang90/SmartRefreshLayout
    const val refreshLayoutKernel = "io.github.scwang90:refresh-layout-kernel:3.0.0-alpha"
    const val refreshLayoutTwoLevel = "io.github.scwang90:refresh-header-two-level:3.0.0-alpha"

    // 滚动选择器库 https://github.com/AigeStudio/WheelPicker
    const val wheelPicker = "cn.aigestudio.wheelpicker:WheelPicker:1.1.3"

    // 图片选择器 https://github.com/yangpeixing/YImagePicker
    const val yImagePicker = "com.ypx.yimagepicker:androidx:3.1.4"

    // 可缩放 PhotoView https://github.com/chrisbanes/PhotoView
    const val photoView = "com.github.chrisbanes:PhotoView:2.3.0"

    // 拼音处理
    const val pinYin4j = "com.belerweb:pinyin4j:2.5.1"

    // 多媒体库
    // Google 媒体播放器，官方推荐代替 MediaPlayer https://github.com/google/media
    const val media3ExoPlayer = "androidx.media3:media3-exoplayer:1.2.0"

    // (这里解释一下DASH（Dynamic Adaptive Streaming over HTTP）即自适应流媒体传输，
    // 什么意思呢，简单概括来说，就是在服务器端提前存好同一内容的不同码率、不同分辨率的多个分片以及相应的描述文件MPD，
    // 客户端在播放时即可以根据自身性能以及网络环境选择最适宜的版本)
    const val media3ExoPlayerDash = "androidx.media3:media3-exoplayer-dash:1.2.0"

    // 播放器 UI 组件 这里暂不需要
    const val media3UI = "androidx.media3:media3-ui:1.2.0"

    // webrtc 库
    const val webrtc = "org.webrtc:google-webrtc:1.0.32006"

    // 自定义工具库 https://gitee.com/lzan13/VMLibrary
    // 自定义工具库 https://github.com/lzan13/VMLibrary
    const val vmtools = "com.github.lzan13:VMLibrary:1.8.3"

}