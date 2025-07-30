package com.vmloft.develop.library.common.ui.debug

import android.view.View
import androidx.core.view.isVisible
import com.didi.drouter.annotation.Router
import com.vmloft.develop.library.common.CConstants

import com.vmloft.develop.library.common.R
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.manager.CSPManager
import com.vmloft.develop.library.common.databinding.ActivityDebugBinding
import com.vmloft.develop.library.common.router.CRouter
import com.vmloft.develop.library.tools.utils.VMStr
import com.vmloft.develop.library.tools.utils.logger.VMLog
import com.vmloft.develop.library.tools.widget.VMFloatMenu

/**
 * Author: lzan13
 * Date: 2020/05/02 22:56
 * Desc: 调试设置
 */
@Router(path = CRouter.commonDebug)
class DebugActivity : BActivity<ActivityDebugBinding>() {

    // 悬浮弹窗
    private lateinit var envFloatMenu: VMFloatMenu

    private var isDebug: Boolean = false
    private var appEnv: Int = CConstants.DebugEnv.online

    override fun initVB() = ActivityDebugBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()
        setTopTitle(R.string.settings_debug)

        binding.debugLV.setOnClickListener { debugSwitch() }
        binding.debugEnvLV.setOnClickListener { view -> showChangeEnvDialog(view) }

        initFloatMenu()
    }

    private fun initFloatMenu() {
        envFloatMenu = VMFloatMenu(this)
        envFloatMenu.addItem(VMFloatMenu.ItemBean(CConstants.DebugEnv.online, getString(R.string.debug_env_online)))
        envFloatMenu.addItem(VMFloatMenu.ItemBean(CConstants.DebugEnv.pre, getString(R.string.debug_env_pre)))
        envFloatMenu.addItem(VMFloatMenu.ItemBean(CConstants.DebugEnv.dev, getString(R.string.debug_env_dev)))
        envFloatMenu.setItemClickListener(object : VMFloatMenu.IItemClickListener() {
            override fun onItemClick(id: Int) {
                CSPManager.setEnv(id)
                checkEnv()
            }
        })
    }

    override fun initData() {
        isDebug = CSPManager.isDebug()
        appEnv = CSPManager.getEnv()

        bindUI()
    }

    private fun debugSwitch() {
        CSPManager.setDebug(!CSPManager.isDebug())

        checkEnv()
    }

    /**
     * 切换环境弹窗
     */
    private fun showChangeEnvDialog(view: View) {
        envFloatMenu.showAtLocation(view, view.x.toInt(), view.y.toInt())
    }

    /**
     * 检查环境
     */
    private fun checkEnv() {
        VMLog.d("changeEnv isDebug:${CSPManager.isDebug()} env:${CSPManager.getEnv()}")

        bindUI()

        if (appEnv != CSPManager.getEnv() || isDebug != CSPManager.isDebug()) {
            if (!binding.debugTips.isVisible) {
                binding.debugTips.visibility = View.VISIBLE
            }
        } else {
            if (binding.debugTips.isVisible) {
                binding.debugTips.visibility = View.GONE
            }
        }
    }

    private fun bindUI() {
        binding.debugLV.isActivated = CSPManager.isDebug()

        val envResId = when (CSPManager.getEnv()) {
            CConstants.DebugEnv.online -> R.string.debug_env_online
            CConstants.DebugEnv.pre -> R.string.debug_env_pre
            CConstants.DebugEnv.dev -> R.string.debug_env_dev
            else -> R.string.debug_env_online
        }
        binding.debugEnvLV.setCaption(VMStr.byRes(envResId))
    }


}