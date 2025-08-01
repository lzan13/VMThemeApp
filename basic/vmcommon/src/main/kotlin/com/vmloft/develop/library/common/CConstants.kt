package com.vmloft.develop.library.common


/**
 * Create by lzan13 on 2020/8/12 22:03
 * 描述：基本常量
 */
object CConstants {

    const val cacheImageDir = "images"

    // 应用在 SDCard 创建区别其他项目目录，一般以项目名命名
    const val projectName = "VMThemeApp"

    // 分页默认数据
    const val defaultPage = 0
    const val defaultLimit = 20
    const val defaultLimitBig = 50

    // 时间常量
    const val timeSecond: Long = 1000
    const val timeMinute: Long = 60 * timeSecond
    const val timeHour: Long = 60 * timeMinute
    const val timeDay = 24 * timeHour // 天

    /**
     * 主题模式
     */
    object ThemeMode {
        const val light = 0
        const val dark = 1
        const val system = 2
    }

    /**
     * 调试环境
     */
    object DebugEnv {
        const val online = 0
        const val pre = 1
        const val dev = 2
    }
}