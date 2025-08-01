package com.vmloft.develop.convention.plugin

import com.vmloft.develop.convention.VMDependencies

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 * Created by lzan13 on 2024/01/25
 * 描述：Library 相关 插件类
 */
class VMLCommon : VMLibrary() {

    /**
     * 加载依赖
     */
    override fun loadDependencies(target: Project) {
        super.loadDependencies(target)
        target.dependencies {
            // 三方控件
            "api"(VMDependencies.agentWeb)

            "api"(VMDependencies.bannerViewPager)

            "api"(VMDependencies.lottie)

            "api"(VMDependencies.panelSwitchHelper)

            "api"(VMDependencies.refreshLayoutKernel)
            "api"(VMDependencies.refreshLayoutTwoLevel)

            "api"(VMDependencies.wheelPicker)

            // gson 数据解析，这里依赖是为了实现数据解析工具封装
            "api"(VMDependencies.gson)

            // 生命周期 EventBus
            "api"(VMDependencies.liveEventBus)

//            "api"(VMDependencies.skinSupport)
//            "api"(VMDependencies.skinSupportAppCompat)
//            "api"(VMDependencies.skinSupportDesign)
//            "api"(VMDependencies.skinSupportCardView)
//            "api"(VMDependencies.skinSupportConstraint)

        }
    }
}