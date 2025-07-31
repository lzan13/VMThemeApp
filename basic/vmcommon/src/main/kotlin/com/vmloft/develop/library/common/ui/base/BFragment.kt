package com.vmloft.develop.library.common.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

import com.vmloft.develop.library.common.R
import com.vmloft.develop.library.common.ui.widget.CommonDialog
import com.vmloft.develop.library.common.utils.CUtils
import com.vmloft.develop.library.tools.utils.VMDimen
import com.vmloft.develop.library.tools.widget.VMTopBar


/**
 * Created by lzan13 on 2020/02/15 11:16
 * 描述：Fragment 基类
 */
abstract class BFragment<VB : ViewBinding> : Fragment() {

    // 公共控件
    protected var commonTopLL: View? = null
    protected var commonTopSpace: View? = null
    protected var commonTopBar: VMTopBar? = null

    protected var mDialog: CommonDialog? = null

    protected var isLoaded: Boolean = false

    // 是否隐藏顶部控件
    open var isHideTopSpace: Boolean = false

    // 是否居中显示标题
    open var isCenterTitle: Boolean = false

    // 是否设置黑色状态栏
    open var isDarkStatusBar: Boolean = true

    private lateinit var _binding: VB
    protected val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = initVB(inflater, parent)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded) {
            isLoaded = true
            initData()
        }
    }


    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            CUtils.setDarkMode(requireActivity(), isDarkStatusBar)
        }
    }

    /**
     * 初始化 ViewBinding
     */
    abstract fun initVB(inflater: LayoutInflater, parent: ViewGroup?): VB

    /**
     * 初始化 UI
     */
    open fun initUI() {
        setupTopBar()
    }

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 装载 TopBar
     */
    protected open fun setupTopBar() {
        CUtils.setDarkMode(requireActivity(), isDarkStatusBar)

        commonTopLL = binding.root.findViewById(R.id.commonTopLL)
        commonTopBar = binding.root.findViewById(R.id.commonTopBar)
        commonTopSpace = binding.root.findViewById(R.id.commonTopSpace)

        if (!isHideTopSpace) {
            // 设置状态栏透明主题时，布局整体会上移，所以给头部 View 设置 StatusBar 的高度
            commonTopSpace?.layoutParams?.height = VMDimen.statusBarHeight
        }

        commonTopBar?.setCenter(isCenterTitle)
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
     * 设置 TopBar 右侧图标按钮及监听
     */
    protected fun setTopEndIcon(resId: Int, listener: View.OnClickListener) {
        commonTopBar?.setEndIcon(resId)
        commonTopBar?.setEndIconListener(listener)
    }

    /**
     * 设置结尾控件
     */
    protected fun setTopEndView(view: View?) {
        commonTopBar?.addEndView(view)
    }


    override fun onDestroy() {
        mDialog?.dismiss()
        super.onDestroy()
    }
}