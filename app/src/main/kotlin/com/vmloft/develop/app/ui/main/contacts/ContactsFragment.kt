package com.vmloft.develop.app.ui.main.contacts

import android.view.LayoutInflater
import android.view.ViewGroup

import com.vmloft.develop.app.databinding.FragmentContactsBinding
import com.vmloft.develop.library.common.ui.base.BFragment

/**
 * Create by lzan13 on 2020/05/02 11:54
 * 描述：发现
 */
class ContactsFragment : BFragment<FragmentContactsBinding>() {

    override fun initVB(inflater: LayoutInflater, parent: ViewGroup?) = FragmentContactsBinding.inflate(inflater, parent, false)

    override fun initUI() {
        super.initUI()

    }

    override fun initData() {

    }

}