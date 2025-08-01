package com.vmloft.develop.app.ui.main.mine


import android.view.LayoutInflater
import android.view.ViewGroup

import com.vmloft.develop.app.R
import com.vmloft.develop.app.databinding.FragmentMineBinding
import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.library.common.router.CRouter
import com.vmloft.develop.library.common.ui.base.BFragment
import com.vmloft.develop.library.common.utils.CUtils


/**
 * Create by lzan13 on 2020/05/02 11:54
 * 描述：我的
 */
class MineFragment : BFragment<FragmentMineBinding>() {


    private var debugCount: Int = 0
    private var lastClickTime: Long = 0L

    override fun initVB(inflater: LayoutInflater, parent: ViewGroup?) = FragmentMineBinding.inflate(inflater, parent, false)

    override fun initUI() {
        super.initUI()
        CUtils.setDarkMode(requireActivity(), false)

        setTopIcon(R.drawable.ic_setting_24)
        setTopEndIcon(R.drawable.ic_more_add) {
            readyOpenDebug()
        }
        binding.themeLV.setOnClickListener {
            CRouter.go(AppRouter.appTheme)
        }

    }

    override fun initData() {

    }

    /**
     * Debug 开关
     */
    fun readyOpenDebug() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime < 320) {
            debugCount++
        }
        lastClickTime = currentTime
        if (debugCount >= 9) {
            debugCount = 0
            CRouter.goDebug()
        }
    }
}