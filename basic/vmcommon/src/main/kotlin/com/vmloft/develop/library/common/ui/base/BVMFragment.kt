package com.vmloft.develop.library.common.ui.base

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.viewbinding.ViewBinding

import com.vmloft.develop.library.common.R
import com.vmloft.develop.library.common.utils.show
import com.vmloft.develop.library.tools.utils.VMNetwork

/**
 * Created by lzan13 on 2020/02/15 11:16
 * 描述：Fragment MVVM 框架基类
 */
abstract class BVMFragment<VB : ViewBinding, VM : BViewModel> : BFragment<VB>() {

    // 公共控件
    protected var commonLoadingLL: View? = null

    protected var emptyStatusLL: View? = null
    protected var emptyStatusIV: ImageView? = null

    protected lateinit var mViewModel: VM


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = initVM()
        initUI()
        startObserve()
    }

    /**
     * 初始化 ViewModel
     */
    abstract fun initVM(): VM

    /**
     * 模型 loading 状态回调
     */
    open fun onModelLoading(model: BViewModel.UIModel) {
        if (model.isLoading) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    /**
     * 模型变化回调
     */
    abstract fun onModelRefresh(model: BViewModel.UIModel)

    open fun onModelError(model: BViewModel.UIModel) {
        model.error?.let { message -> requireActivity().show(message) }
    }

    /**
     * 开始观察 View 生命周期
     */
    private fun startObserve() {
        mViewModel.uiState.observe(viewLifecycleOwner, {
            onModelLoading(it)
            if (!it.isLoading) {
                if (it.isSuccess) {
                    onModelRefresh(it)
                } else {
                    onModelError(it)
                }
                it.toast?.let { message -> requireActivity().show(message) }
            }
        })
    }

    /**
     * 装载 TopBar
     */
    override fun setupTopBar() {
        super.setupTopBar()
        commonLoadingLL = binding.root.findViewById(R.id.commonLoadingLL)

        emptyStatusLL = binding.root.findViewById(R.id.emptyStatusLL)
        emptyStatusIV = binding.root.findViewById(R.id.emptyStatusIV)

    }


    /**
     * 显示 loading
     */
    protected fun showLoading() {
        commonLoadingLL?.visibility = View.VISIBLE
    }

    /**
     * 隐藏 loading
     */
    protected fun hideLoading() {
        commonLoadingLL?.visibility = View.GONE
    }

    /**
     * 隐藏空态
     */
    protected fun hideEmptyView() {
        emptyStatusLL?.visibility = View.GONE
    }

    /**
     * 显示没有数据
     */
    protected fun showEmptyNoData() {
//        emptyStatusIV?.setImageResource(R.drawable.ic_empty_data)
        emptyStatusLL?.visibility = View.VISIBLE
    }

    /**
     * 显示请求失败
     */
    protected fun showEmptyFailed() {
        if (VMNetwork.hasNetwork()) {
//            emptyStatusIV?.setImageResource(R.drawable.ic_empty_failed)
        } else {
//            emptyStatusIV?.setImageResource(R.drawable.ic_empty_network)
        }
        emptyStatusLL?.visibility = View.VISIBLE
    }

    /**
     * 设置空态点击事件
     */
    protected fun setEmptyClick(listener: View.OnClickListener) {
        emptyStatusIV?.setOnClickListener { listener.onClick(it) }
    }

}
