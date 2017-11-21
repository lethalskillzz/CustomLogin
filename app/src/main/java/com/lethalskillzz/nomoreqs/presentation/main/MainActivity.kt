package com.lethalskillzz.nomoreqs.presentation.main

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.view.WindowManager
import butterknife.ButterKnife
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationItem
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
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

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
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
