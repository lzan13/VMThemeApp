package com.vmloft.develop.app.ui.user

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

import com.didi.drouter.annotation.Router

import com.google.android.material.tabs.TabLayoutMediator

import com.vmloft.develop.app.R
import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.app.common.CommonFragment
import com.vmloft.develop.app.databinding.ActivityUserInfoBinding
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.utils.CUtils


/**
 * Create by lzan13 on 2021/01/20 22:56
 * 描述：用户信息界面
 */
@Router(path = AppRouter.appUserInfo)
class UserInfoActivity : BActivity<ActivityUserInfoBinding>() {

    private val fragmentList = arrayListOf<Fragment>()
    private lateinit var publishFragment: CommonFragment
    private lateinit var likeFragment: CommonFragment

    private val titles = listOf("发布", "喜欢")

    override fun initVB() = ActivityUserInfoBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()
        CUtils.setDarkMode(this, false)


    }

    override fun initData() {
        initFragmentList()
        initViewPager()
    }

    /**
     * 初始化 Fragment 集合
     */
    private fun initFragmentList() {
        publishFragment = CommonFragment.newInstance(titles[0])
        likeFragment = CommonFragment.newInstance(titles[1])

        fragmentList.run {
            add(publishFragment)
            add(likeFragment)
        }
    }

    /**
     * 初始化 ViewPager
     */
    private fun initViewPager() {
        binding.viewPager.offscreenPageLimit = titles.size - 1
        binding.viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int) = fragmentList[position]

            override fun getItemCount() = fragmentList.size
        }
        // 将 TabLayout 与 ViewPager 进行绑定
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()
    }
}