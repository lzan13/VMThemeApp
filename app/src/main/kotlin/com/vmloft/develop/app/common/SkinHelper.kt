package com.vmloft.develop.app.common

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

import com.vmloft.develop.library.common.CConstants
import com.vmloft.develop.library.common.manager.CSPManager
import com.vmloft.develop.library.tools.utils.logger.VMLog

import skin.support.SkinCompatManager
import skin.support.SkinCompatManager.SkinLoaderListener
import skin.support.app.SkinAppCompatViewInflater
import skin.support.app.SkinCardViewInflater
import skin.support.constraint.app.SkinConstraintViewInflater
import skin.support.design.app.SkinMaterialViewInflater

/**
 * author: lzan13
 * date: 2025/8/1
 * description:
 */
object SkinHelper {

    /**
     * 初始化换肤
     */
    fun init(app: Application) {
        SkinCompatManager.withoutActivity(app)
//            .addStrategy(new CustomSDCardLoader ())          // 自定义加载策略，指定SDCard路径
//            .addStrategy(new ZipSDCardLoader ())             // 自定义加载策略，获取zip包中的资源
            .addInflater(SkinAppCompatViewInflater()) // 基础控件换肤
            .addInflater(SkinMaterialViewInflater()) // material design
            .addInflater(SkinConstraintViewInflater()) // ConstraintLayout
            .addInflater(SkinCardViewInflater()) // CardView v7
//            .setSkinStatusBarColorEnable(true)              // 关闭状态栏换肤
//            .setSkinWindowBackgroundEnable(false)           // 关闭windowBackground换肤
//            .setSkinAllActivityEnable(true)                // true: 默认所有的Activity都换肤; false: 只有实现SkinCompatSupportable接口的Activity换肤
            .loadSkin()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        checkThemeSkin()

        checkThemeMode()
    }

    /**
     * 检查主题皮肤
     */
    private fun checkThemeSkin() {
        val themeSkin = CSPManager.getThemeSkin()
        if (themeSkin == "golden") {
            // 恢复应用默认皮肤
            SkinCompatManager.getInstance().restoreDefaultTheme()
        } else {
            // 指定皮肤插件
            SkinCompatManager.getInstance().loadSkin("$themeSkin.skin", object : SkinLoaderListener {
                override fun onStart() {
                    VMLog.d("switchThemeSkin.onStart")
                }

                override fun onSuccess() {
                    VMLog.d("switchThemeSkin.onSuccess")
                }

                override fun onFailed(msg: String) {
                    VMLog.d("switchThemeSkin.onFailed msg:$msg")
                }
            }, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS)
        }
    }

    /**
     * 检查主题模式
     */
    private fun checkThemeMode() {
        if (CSPManager.getThemeMode() == CConstants.ThemeMode.light) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else if (CSPManager.getThemeMode() == CConstants.ThemeMode.dark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

}