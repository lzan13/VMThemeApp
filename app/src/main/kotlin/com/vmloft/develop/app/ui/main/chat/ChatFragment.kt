package com.vmloft.develop.app.ui.main.chat

import android.view.LayoutInflater
import android.view.ViewGroup

import com.vmloft.develop.app.databinding.FragmentChatBinding
import com.vmloft.develop.library.common.ui.base.BFragment


/**
 * Create by lzan13 on 2020/05/02 11:54
 * 描述：首页
 */
class ChatFragment : BFragment<FragmentChatBinding>() {

    override fun initVB(inflater: LayoutInflater, parent: ViewGroup?) = FragmentChatBinding.inflate(inflater, parent, false)

    override fun initUI() {
        super.initUI()

    }

    override fun initData() {
    }


}