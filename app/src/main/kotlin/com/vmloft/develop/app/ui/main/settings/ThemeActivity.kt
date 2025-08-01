package com.vmloft.develop.app.ui.main.settings


import androidx.appcompat.app.AppCompatDelegate
import com.didi.drouter.annotation.Router
import com.vmloft.develop.app.R

import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.app.databinding.ActivityThemeBinding
import com.vmloft.develop.library.common.CConstants
import com.vmloft.develop.library.common.manager.CSPManager
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.tools.utils.logger.VMLog
import skin.support.SkinCompatManager
import skin.support.SkinCompatManager.SkinLoaderListener
import skin.support.SkinCompatManager.SkinLoaderStrategy


/**
 * Create by lzan13 on 2021/01/20 22:56
 * 描述：用户信息界面
 */
@Router(path = AppRouter.appTheme)
class ThemeActivity : BActivity<ActivityThemeBinding>() {

    private var themeMode: Int = CConstants.ThemeMode.system
    private var themeSkin: String = ""

    override fun initVB() = ActivityThemeBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()

        setTopIcon(R.drawable.ic_back)

        binding.modeLightTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.light) }
        binding.modeDarkTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.dark) }
        binding.modeSystemTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.system) }

        binding.skinGoldenTV.setOnClickListener { switchThemeSkin("golden") }
        binding.skinBasilTV.setOnClickListener { switchThemeSkin("basil") }
        binding.skinBlueTV.setOnClickListener { switchThemeSkin("blue") }
        binding.skinCosmopolitanTV.setOnClickListener { switchThemeSkin("cosmopolitan") }


        binding.switchLV.setOnClickListener { binding.switchLV.isActivated = !binding.switchLV.isActivated }
        binding.switchLV.isActivated = true
    }

    override fun initData() {
        themeMode = CSPManager.getThemeMode()
        themeSkin = CSPManager.getThemeSkin()

        bindUI()
    }

    private fun switchThemeMode(mode: Int) {
        themeMode = mode
        CSPManager.setThemeMode(mode)

        if (CSPManager.getThemeMode() == CConstants.ThemeMode.light) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else if (CSPManager.getThemeMode() == CConstants.ThemeMode.dark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        bindUI()
    }

    private fun switchThemeSkin(skin: String) {
        themeSkin = skin
        CSPManager.setThemeSkin(skin)
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
        bindUI()
    }

    /**
     *
     */
    private fun bindUI() {
        binding.modeLightTV.isSelected = themeMode == CConstants.ThemeMode.light
        binding.modeDarkTV.isSelected = themeMode == CConstants.ThemeMode.dark
        binding.modeSystemTV.isSelected = themeMode == CConstants.ThemeMode.system

        binding.skinGoldenTV.isSelected = themeSkin == "golden"
        binding.skinBasilTV.isSelected = themeSkin == "basil"
        binding.skinBlueTV.isSelected = themeSkin == "blue"
        binding.skinCosmopolitanTV.isSelected = themeSkin == "cosmopolitan"
    }

}