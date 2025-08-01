package com.vmloft.develop.convention.plugin

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.PluginManager

import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Created by lzan13 on 2024/01/25
 * 描述：自定义插件基类
 */
abstract class VMBase : Plugin<Project> {
    /**
     * 插件入口
     */
    override fun apply(target: Project) {
        // 加载 gradle 配置
        with(target) {
            // 加载插件
            loadPlugin(pluginManager)
            // 加载扩展配置
            loadExtensions(target)
            // 加载依赖
            loadDependencies(target)
        }
    }

    /**
     * 加载插件
     */
    abstract fun loadPlugin(pluginManager: PluginManager)

    /**
     * 加载扩展配置
     */
    abstract fun loadExtensions(target: Project)

    /**
     * 加载依赖
     */
    abstract fun loadDependencies(target: Project)

    /**
     * 自定义 KotlinOptions 扩展函数
     */
    fun ApplicationExtension.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
        (this as ExtensionAware).extensions.configure("kotlinOptions", block)
    }

    /**
     * 自定义 KotlinOptions 扩展函数
     */
    fun LibraryExtension.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
        (this as ExtensionAware).extensions.configure("kotlinOptions", block)
    }
}