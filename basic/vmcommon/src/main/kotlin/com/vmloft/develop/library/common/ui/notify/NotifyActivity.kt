package com.vmloft.develop.library.common.ui.notify

import android.content.Intent
import android.os.Bundle

import com.vmloft.develop.library.common.databinding.ActivityNotifyBinding
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.router.CRouter


/**
 * Create by lzan13 2022/03/28
 * 描述：通知栏提醒中间页，做页面中转用
 */
class NotifyActivity : BActivity<ActivityNotifyBinding>() {

    override fun initVB() = ActivityNotifyBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()
    }

    override fun initData() {
        val bundle = intent.getBundleExtra("params") ?: return CRouter.goMain()

        checkBName(bundle)
    }

    private fun checkBName(bundle: Bundle) {
        val bname = bundle.getString("bname")
        if (bname == "im") {
            val chatId = bundle.getString("chatId") ?: ""
            val extend = bundle.getString("extend") ?: ""
            CRouter.go("/IM/Chat", 0, str0 = chatId, str1 = extend, flags = Intent.FLAG_ACTIVITY_NEW_TASK)
        } else {
            CRouter.goMain()
        }
        // 打开其他页面后关闭中间页
        finish()
    }

}