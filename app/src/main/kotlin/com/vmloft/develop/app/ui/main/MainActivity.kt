package com.vmloft.develop.app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.didi.drouter.annotation.Router
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.vmloft.develop.app.R
import com.vmloft.develop.app.databinding.ActivityMainBinding
import com.vmloft.develop.app.router.AppRouter
import com.vmloft.develop.app.ui.main.chat.ChatFragment
import com.vmloft.develop.app.ui.main.mine.MineFragment
import com.vmloft.develop.app.ui.main.contacts.ContactsFragment
import com.vmloft.develop.library.common.ui.base.BActivity
import com.vmloft.develop.library.common.ui.notify.NotifyManager


/**
 * Create by lzan13 on 2018/4/13
 */
@Router(path = AppRouter.appMain)
class MainActivity : BActivity<ActivityMainBinding>() {

    private val tabChat = 0
    private val tabContacts = 1
    private val tabMine = 2

    private val currentTabKey = "currentTabKey"
    private val fragmentKeys = arrayListOf("chatKey", "contactsKey", "mineKey")
    private var currentTab = tabChat
    private var currentFragment: Fragment? = null

    private val fragmentList = arrayListOf<Fragment>()
    private lateinit var chatFragment: ChatFragment
    private lateinit var contactsFragment: ContactsFragment
    private lateinit var mineFragment: MineFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            fragmentList.clear()
            initFragmentList()
        } else {
            //内存被回收了，fragments的list也被回收了，重新add进去
            currentTab = savedInstanceState.getInt(currentTabKey)
            fragmentList.clear()
            chatFragment = (supportFragmentManager.findFragmentByTag(fragmentKeys[0]) as ChatFragment?) ?: ChatFragment()
            contactsFragment = (supportFragmentManager.findFragmentByTag(fragmentKeys[1]) as ContactsFragment?) ?: ContactsFragment()
            mineFragment = (supportFragmentManager.findFragmentByTag(fragmentKeys[2]) as MineFragment?) ?: MineFragment()
            fragmentList.run {
                add(chatFragment)
                add(contactsFragment)
                add(mineFragment)
            }
            currentFragment = fragmentList[currentTab]
        }
        switchFragment(currentTab)
    }

    override fun initVB() = ActivityMainBinding.inflate(layoutInflater)

    override fun initUI() {
        super.initUI()
//        setTheme(R.style.AppTheme)

        initBottomNav()
    }

    override fun initData() {

        NotifyManager.checkNotifySetting()
    }

    /**
     * 初始化底部导航
     */
    private fun initBottomNav() {
        // TODO 如果导航是多色图标，需要取消 BottomNavigationView 的着色效果，自己去设置 selector
        // mainNav.itemIconTintList = null
        binding.mainNav.setOnNavigationItemSelectedListener(onNavigationItemSelected)
    }

    /**
     * 导航监听
     */
    private val onNavigationItemSelected = BottomNavigationView.OnNavigationItemSelectedListener {
        when (it.itemId) {
            R.id.nav_chat -> switchFragment(tabChat)
            R.id.nav_contacts -> switchFragment(tabContacts)
            R.id.nav_mine -> switchFragment(tabMine)
        }
        true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 保存当前 Tab
        outState.putInt(currentTabKey, currentTab)
    }

    /**
     * 界面切换
     */
    private fun switchFragment(tab: Int) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val oldFragment: Fragment = fragmentList[currentTab]
        val newFragment: Fragment = fragmentList[tab]
        if (currentFragment == null) {
            transaction.add(R.id.mainFragmentContainer, newFragment, fragmentKeys[tab])
                .commit()
        } else {
            if (newFragment.isAdded) {
                transaction.hide(oldFragment).show(newFragment).commit()
            } else {
                transaction.hide(oldFragment)
                    .add(R.id.mainFragmentContainer, newFragment, fragmentKeys[tab])
                    .commit()
            }
        }

        currentTab = tab
        currentFragment = newFragment
    }

    /**
     * 初始化 Fragment 集合
     */
    private fun initFragmentList() {
        chatFragment = ChatFragment()
        contactsFragment = ContactsFragment()
        mineFragment = MineFragment()

        fragmentList.run {
            add(chatFragment)
            add(contactsFragment)
            add(mineFragment)
        }
    }
}