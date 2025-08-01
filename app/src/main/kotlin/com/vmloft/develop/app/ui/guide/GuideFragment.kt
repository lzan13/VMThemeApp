package com.vmloft.develop.app.ui.guide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vmloft.develop.library.common.ui.base.BFragment
import com.vmloft.develop.app.databinding.FragmentGuideBinding
import com.vmloft.develop.library.tools.utils.VMView

/**
 * Create by lzan13 on 2020/05/02 11:54
 * 描述：主页
 */
class GuideFragment : BFragment<FragmentGuideBinding>() {

    companion object {
        private val argImgId = "argImgId"
        private val argTitleId = "argTitleId"
        private val argBodyId = "argBodyId"

        /**
         * Fragment 的工厂方法，方便创建并设置参数
         */
        fun newInstance(imgId: Int, titleId: Int, bodyId: Int): GuideFragment {
            val fragment = GuideFragment()
            val args = Bundle()
            args.putInt(argImgId, imgId)
            args.putInt(argTitleId, titleId)
            args.putInt(argBodyId, bodyId)
            fragment.arguments = args
            return fragment
        }
    }


    override fun initVB(inflater: LayoutInflater, parent: ViewGroup?) = FragmentGuideBinding.inflate(inflater, parent, false)

    override fun initUI() {
        super.initUI()

        VMView.changeShadow(binding.guideCardLL)
        binding.guideCoverIV.setImageResource(requireArguments().getInt(argImgId))
        binding.guideTitleTV.setText(requireArguments().getInt(argTitleId))
        binding.guideBodyTV.setText(requireArguments().getInt(argBodyId))
    }

    override fun initData() {
        loadAnim()
    }


    private fun loadAnim() {}
}

