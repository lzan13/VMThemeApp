package com.vmloft.develop.library.common.ui.base

import android.app.Activity
import android.app.Dialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.SkinAppCompatDelegateImpl
import androidx.viewbinding.ViewBinding

import com.gyf.immersionbar.ImmersionBar

import com.vmloft.develop.library.common.R
import com.vmloft.develop.library.common.utils.CUtils
import com.vmloft.develop.library.tools.utils.VMDimen
import com.vmloft.develop.library.tools.widget.VMTopBar

/**
 * Created by lzan13 on 2020/02/15 11:16
 * 描述：Activity 基类
 */
abstract class BActivity<VB : ViewBinding> : AppCompatActivity() {

    // 公共控件
    protected var commonTopLL: View? = null
    protected var commonTopSpace: View? = null
    protected var commonTopBar: VMTopBar? = null

    protected var mDialog: Dialog? = null

    protected lateinit var mActivity: Activity

    // 是否隐藏顶部控件
    open var isHideTopSpace: Boolean = false

    // 是否居中显示标题
    open var isCenterTitle: Boolean = false

    // 是否设置黑色状态栏
    open var isDarkStatusBar: Boolean = true

    protected lateinit var _binding: VB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initVB()
        setContentView(_binding.root)

        mActivity = this

        initUI()

        initData()
    }

    /**
     * 初始化 ViewBinding
     */
    abstract fun initVB(): VB

    /**
     * 初始化 UI
     */
    open fun initUI() {
        setupBar()
        setupTopBar()
    }

    /**
     * 初始化数据
     */
    abstract fun initData()

    private fun setupBar() {
        // 解决内容没有延伸到状态栏下问题
        ImmersionBar.with(this).reset()
            .barEnable(true)
            .transparentBar()
            .fitsSystemWindows(false)
            .init()
    }

    /**
     * 装载 TopBar
     */
    protected open fun setupTopBar() {
        CUtils.setDarkMode(mActivity, isDarkStatusBar)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        commonTopLL = binding.root.findViewById(R.id.commonTopLL)
        commonTopBar = binding.root.findViewById(R.id.commonTopBar)
        commonTopSpace = binding.root.findViewById(R.id.commonTopSpace)
        if (!isHideTopSpace) {
            // 设置状态栏透明主题时，布局整体会上移，所以给头部 View 设置 StatusBar 的高度
            commonTopSpace?.layoutParams?.height = VMDimen.statusBarHeight
        }

        commonTopBar?.setCenter(isCenterTitle)
        commonTopBar?.setIconListener { onBackPressed() }
    }

    /**
     * 设置顶部标题背景色
     */
    protected fun setTopBGColor(color: Int) {
        commonTopLL?.setBackgroundColor(color)
    }

    /**
     * 设置图标
     */
    protected fun setTopIcon(resId: Int, listener: OnClickListener? = null) {
        commonTopBar?.setIcon(resId)
        if (listener != null) {
            commonTopBar?.setIconListener(listener)
        }
    }

    /**
     * 设置图标颜色
     */
    protected fun setTopIconColor(color: Int) {
        commonTopBar?.setIconColor(color)
    }

    /**
     * 设置标题
     */
    protected fun setTopTitle(resId: Int) {
        commonTopBar?.setTitle(resId)
    }

    /**
     * 设置标题
     */
    protected fun setTopTitle(title: String) {
        commonTopBar?.setTitle(title)
    }

    /**
     * 设置二级标题
     */
    protected fun setTopSubTitle(title: String) {
        commonTopBar?.setSubtitle(title)
    }

    /**
     * 设置标题颜色
     */
    protected fun setTopTitleColor(resId: Int) {
        commonTopBar?.setTitleColor(resId)
    }

    /**
     * 设置子标题
     */
    protected fun setTopSubtitle(subTitle: String) {
        commonTopBar?.setSubtitle(subTitle)
    }

    /**
     * 设置 TopBar 右侧按钮状态
     */
    protected fun setTopEndBtnEnable(enable: Boolean) {
        commonTopBar?.setEndBtnEnable(enable)
    }

    /**
     * 设置 TopBar 右侧按钮
     */
    protected fun setTopEndBtn(str: String?) {
        commonTopBar?.setEndBtn(str)
    }

    /**
     * 设置 TopBar 右侧按钮监听
     */
    protected fun setTopEndBtnListener(str: String? = null, listener: View.OnClickListener) {
        commonTopBar?.setEndBtnListener(str, listener)
    }

    /**
     * 设置 TopBar 右侧图标按钮及监听
     */
    protected fun setTopEndIcon(resId: Int, listener: View.OnClickListener) {
        commonTopBar?.setEndIcon(resId)
        commonTopBar?.setEndIconListener(listener)
    }

    override fun onDestroy() {
        mDialog?.dismiss()
        super.onDestroy()
    }

    override fun getDelegate(): AppCompatDelegate {
        return SkinAppCompatDelegateImpl.get(this, this)
    }
}
