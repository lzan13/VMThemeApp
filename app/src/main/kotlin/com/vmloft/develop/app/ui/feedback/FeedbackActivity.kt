package com.vmloft.develop.app.ui.feedback

import com.didi.drouter.annotation.Router
import com.vmloft.develop.library.common.ui.base.BActivity

import com.vmloft.develop.app.R
import com.vmloft.develop.app.databinding.ActivityFeedbackBinding
import com.vmloft.develop.app.router.AppRouter


/**
 * Create by lzan13 on 2020/6/17 17:10
 * 描述：问题反馈
 */
@Router(path = AppRouter.appFeedback)
class FeedbackActivity : BActivity<ActivityFeedbackBinding>() {

    override fun initVB() = ActivityFeedbackBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()
        setTopTitle(R.string.settings_feedback)
    }

    override fun initData() {

    }

}
