package com.vmloft.develop.app.ui.splash

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.router.CRouter
import com.vmloft.develop.app.common.SPManager
import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.app.ui.widget.AgreementPolicyDialog
import com.vmloft.develop.app.databinding.ActivitySplashBinding

/**
 * Create by lzan13 2021/5/17
 * 描述：闪屏页，做承接调整用
 */
class SplashActivity : BActivity<ActivitySplashBinding>() {

    override fun initVB() = ActivitySplashBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
    }

    override fun initUI() {
        super.initUI()
        if (SPManager.isNeedShowPolicy()) {
            showAgreementPolicy()
        } else {
            jump()
        }
    }

    override fun initData() {

    }

    private fun jump() {
        if (SPManager.isNeedShowGuide()) {
            CRouter.go(AppRouter.appGuide)
//        } else if (!SignManager.isSingIn()) {
//            CRouter.go(AppRouter.appSignGuide)
        } else {
            CRouter.goMain()
        }
        finish()
    }

    private fun showAgreementPolicy() {
        mDialog = AgreementPolicyDialog(this)
        (mDialog as AgreementPolicyDialog).let { dialog ->
            dialog.setNegative("不同意") {
                finish()
            }
            dialog.setPositive("同意") {
                SPManager.setAgreementPolicyDone()
                jump()
            }
            dialog.show()
        }
    }
}