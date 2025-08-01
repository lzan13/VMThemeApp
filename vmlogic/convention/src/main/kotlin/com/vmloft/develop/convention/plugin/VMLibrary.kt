package com.vmloft.develop.convention.plugin

import com.android.build.api.dsl.LibraryExtension

import com.vmloft.develop.convention.VMConfig
import com.vmloft.develop.convention.VMDependencies

import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Created by lzan13 on 2024/01/25
 * 描述：Library 相关 插件类
 */
open class VMLibrary : VMBase() {

    /**
     * 加载插件
     */
    override fun loadPlugin(pluginManager: PluginManager) {
        // 加载插件
        with(pluginManager) {
            apply("com.android.library")
            apply("com.google.devtools.ksp")
            apply("org.jetbrains.kotlin.android")
            apply("org.jetbrains.kotlin.plugin.parcelize")
        }
    }

    /**
     * 加载扩展配置
     */
    override fun loadExtensions(target: Project) {
        target.extensions.configure<LibraryExtension>() {
            // 设置 android sdk 相关版本
            compileSdk = VMConfig.compileSdk

            defaultConfig {
                minSdk = VMConfig.minSdk
            }

            buildTypes {
                getByName("release") {
                    isMinifyEnabled = false
                    proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    consumerProguardFiles("consumer-rules.pro")
                }
            }

            buildFeatures {
                // 开启 BuildConfig
                buildConfig = VMConfig.isBuildConfig
                // 开启 resValues 用来代替 buildConfigField
                resValues = VMConfig.isResValues
                // 启用 compose
                compose = VMConfig.isCompose
                // 开启 ViewBinding
                viewBinding = VMConfig.isViewBinding
            }

            // compose 配置
            composeOptions {
//                kotlinCompilerExtensionVersion = VMConfig.composeCompilerVersion
            }

            // 配置 Java 编译版本
            compileOptions {
                sourceCompatibility = VMConfig.javaVersion
                targetCompatibility = VMConfig.javaVersion
            }

            // Kotlin 配置 默认没有，需要自己写个扩展
            kotlinOptions {
                jvmTarget = VMConfig.javaVersion.toString()
            }

            lint {
                // 编译忽略错误配置
                abortOnError = false
                // 设置目标 sdk 版本
                targetSdk = VMConfig.targetSdk
            }
        }
    }

    /**
     * 加载依赖
     */
    override fun loadDependencies(target: Project) {
        target.dependencies {
            // kotlin相关
            "api"(VMDependencies.coreKtx)
            "api"(VMDependencies.kotlinxCoroutinesCore)
            "api"(VMDependencies.kotlinxCoroutinesAndroid)

            // AndroidX 相关
            "api"(VMDependencies.appCompat)
            "api"(VMDependencies.constraintLayout)
            "api"(VMDependencies.coordinatorLayout)
            "api"(VMDependencies.localBroadcastManager)
            "api"(VMDependencies.material)

            // JetPack 相关
            "api"(VMDependencies.activityKtx)
            "api"(VMDependencies.fragmentKtx)
            "api"(VMDependencies.lifecycleExtensions)
            "api"(VMDependencies.lifecycleLivedataKtx)
            "api"(VMDependencies.lifecycleViewModelKtx)

            // 多类型适配，定义基类
            "api"(VMDependencies.multiType)

            // koin 依赖注入
            "api"(VMDependencies.koin)

            "api"(VMDependencies.immersionbar)
            "api"(VMDependencies.immersionbarKtx)

            // DiDi 路由
            "api"(VMDependencies.dRouter)

            // 自定义工具库
            "api"(VMDependencies.vmtools)
        }
    }
}