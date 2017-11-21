package com.lethalskillzz.nomoreqs.presentation.main

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.util.Log
import android.view.View
import android.view.WindowManager
import butterknife.ButterKnife
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.data.model.User
import com.lethalskillzz.nomoreqs.presentation.base.BaseActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationItem
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationItemSelectedListener
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.onClick
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.scale
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.toPx
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import javax.inject.Inject
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationId as Id


/**
 * Created by ibrahimabdulkadir on 20/11/2017.
 */


class MainActivity : BaseActivity(), MainMvpView, NavigationItemSelectedListener {

    @Inject lateinit var mPresenter: MainMvpPresenter<MainMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT

        activityComponent!!.inject(this)

        setUnBinder(ButterKnife.bind(this))

        mPresenter!!.onAttach(this@MainActivity)

        setUp()

    }


    protected override fun onDestroy() {
        mPresenter!!.onDetach()
        super.onDestroy()
    }

    protected override fun setUp() {

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        navView.navigationItemSelectListener = this
        navView.header.userName

        drawerLayout.drawerElevation = 0F
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val moveFactor = navView.width * slideOffset
                mainView.translationX = moveFactor
                mainView.scale = 1 - slideOffset / 4
                mainView.cardElevation = slideOffset * 10.toPx(this@MainActivity)
            }

            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
                mPresenter.handleDrawerOpen()
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
                mPresenter.handleDrawerClose()
            }
        })
        drawerLayout.setScrimColor(Color.TRANSPARENT)

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun setToolBarTitle(title: String) {
        toolbarTitle?.setAnimatedText(title)
    }

//    override fun onFragmentChanged(currentTag: String, currentFragment: Fragment) {
//        presenter.handleFragmentChanges(currentTag, currentFragment)
//    }

    override fun updateDrawerInfo(user: User) {
        val header = navView.header
        with(header) {
//            userName.text = user.name
//            userInfo.text = user.location
//            userAvatar.load(user.avatarUrl, TransformationType.CIRCLE)
        }
    }

    override fun setArcArrowState() {
        arcView.onClick {
            super.onBackPressed()
        }
        arcImage.setAnimatedImage(R.drawable.arrow_left)
    }

    override fun setArcHamburgerIconState() {
        drawerLayout?.let {
            arcView.onClick {
                Log.e("AAAA", "HAHAHAH")
                drawerLayout.openDrawer(GravityCompat.START)
            }
            arcImage.setAnimatedImage(R.drawable.hamb)
        }
    }


    override fun checkNavigationItem(position: Int) {
        navView?.let {
            navView.setChecked(position)
        }
    }


    override fun onBackPressed() {
        when {
            drawerLayout.isDrawerOpen(GravityCompat.START) -> drawerLayout.closeDrawer(GravityCompat.START)
            else -> super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: NavigationItem) {
        when (item.id) {
            Id.ABOUT -> {
                //goTo<AboutFragment>()
            }
            Id.LOG_OUT -> {
                //presenter.logOut()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun remove(fragment: BaseFragment) {
    }
}
