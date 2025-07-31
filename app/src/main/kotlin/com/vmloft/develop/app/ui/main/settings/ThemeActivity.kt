package com.vmloft.develop.app.ui.main.settings


import com.didi.drouter.annotation.Router

import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.app.databinding.ActivityThemeBinding
import com.vmloft.develop.library.common.CConstants
import com.vmloft.develop.library.common.manager.CSPManager
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.utils.CUtils


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
        CUtils.setDarkMode(this, false)
        binding.modeLightTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.light) }
        binding.modeDarkTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.dark) }
        binding.modeSystemTV.setOnClickListener { switchThemeMode(CConstants.ThemeMode.system) }

        binding.skinGoldenTV.setOnClickListener { switchThemeSkin("golden") }
        binding.skinBasilTV.setOnClickListener { switchThemeSkin("basil") }
        binding.skinBlueTV.setOnClickListener { switchThemeSkin("blue") }
        binding.skinCosmopolitanTV.setOnClickListener { switchThemeSkin("cosmopolitan") }

    }

    override fun initData() {
        themeMode = CSPManager.getThemeMode()
        themeSkin = CSPManager.getThemeSkin()

        bindUI()
    }

    private fun switchThemeMode(mode: Int) {
        themeMode = mode
        CSPManager.setThemeMode(mode)
        bindUI()
    }

    private fun switchThemeSkin(skin: String) {
        CSPManager.setThemeSkin(skin)
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