package com.kangyj.aactemplate.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.annotation.IdRes
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.alibaba.android.arouter.facade.annotation.Route
import com.kangyj.aactemplate.ARouterUri
import com.kangyj.aactemplate.R
import com.kangyj.aactemplate.ui.home.ui.dashboard.DashboardFragment
import com.kangyj.aactemplate.ui.home.ui.home.HomeFragment
import com.kangyj.aactemplate.ui.home.ui.notifications.NotificationsFragment
import com.kangyj.libaac.base.BaseActivity
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.activity_home.*

@Route(path = ARouterUri.HomeActivity)
class HomeActivity : BaseActivity<HomePageModel, ViewDataBinding>(),
    BottomNavigationView.OnNavigationItemSelectedListener {


    override fun getLayoutId(): Int {
        return R.layout.activity_home
    }

    override fun getReplaceView(): View {
        return viewpager
    }

    override fun init(savedInstanceState: Bundle?) {
//        val navView: BottomNavigationView = findViewById(R.id.nav_view)
//
//        val navController = findNavController(R.id.nav_host_fragment)
//        // get fragment
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
//
//        // setup custom navigator
//        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.nav_host_fragment)
//        navController.navigatorProvider += navigator
//
//        // set navigation graph
//        navController.setGraph(R.navigation.mobile_navigation)
//
//        navView.setupWithNavController(navController)
        nav_view.setOnNavigationItemSelectedListener(this)
        viewpager.offscreenPageLimit = 3
        viewpager.adapter = object :
            FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
                return TabFragment.values().size
            }

            override fun getItem(position: Int): Fragment {
                return TabFragment.values()[position].fragment()
            }
        }
        /**
         * viewpager左右滑的切换
         */
        viewpager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                nav_view.menu.getItem(position).isChecked = true
            }
        })
    }

    override fun getSmartRefreshLayout(): SmartRefreshLayout? {
        return null
    }

    override fun refreshData() {
    }

    /**
     * BottomNavigationView的选中
     */
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        (findViewById<ViewPager>(R.id.viewpager)).currentItem = TabFragment.from(
            menuItem.itemId
        ).ordinal
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
//        TabFragment.onDestroy()
    }

    /**
     * TabFragment
     *
     */
    private enum class TabFragment(@IdRes menuId: Int, clazz: Class<out Fragment>) {
        home(R.id.navigation_home, HomeFragment::class.java),
        dashboard(R.id.navigation_dashboard, DashboardFragment::class.java),
        notifications(R.id.navigation_notifications, NotificationsFragment::class.java);

        private var fragment: Fragment? = null
        private val menuId: Int
        private val clazz: Class<out Fragment>
        fun fragment(): Fragment {
            if (fragment == null) {
                fragment = try {
                    clazz.newInstance()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Fragment()
                }
            }
            return fragment!!
        }

        companion object {
            fun from(itemId: Int): TabFragment {
                for (fragment in TabFragment.values()) {
                    if (fragment.menuId == itemId) {
                        return fragment
                    }
                }
                return home
            }

            fun onDestroy() {
                for (fragment in TabFragment.values()) {
                    fragment.fragment = null
                }
            }
        }

        init {
            this.menuId = menuId
            this.clazz = clazz
        }
    }


}