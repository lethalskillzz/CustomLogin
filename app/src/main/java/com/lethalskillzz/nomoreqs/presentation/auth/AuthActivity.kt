package com.lethalskillzz.nomoreqs.presentation.auth

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.WindowManager
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.flip.AnimatedViewPager
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

class AuthActivity : BaseActivity(), AuthMvpView {

    @Inject lateinit var mPresenter: AuthMvpPresenter<AuthMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT

        activityComponent!!.inject(this)

        //setUnBinder(ButterKnife.bind(this))

        mPresenter!!.onAttach(this@AuthActivity)

        setUp()

    }


    protected override fun onDestroy() {
        mPresenter!!.onDetach()
        super.onDestroy()
    }

    protected override fun setUp() {
        val pager = findViewById<AnimatedViewPager>(R.id.pager)
        pager.adapter = AuthAdapter(supportFragmentManager, pager)
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, AuthActivity::class.java)
        }
    }

    override fun remove(fragment: BaseFragment) {
    }
}
