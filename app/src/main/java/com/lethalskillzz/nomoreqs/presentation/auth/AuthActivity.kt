package com.lethalskillzz.nomoreqs.presentation.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.AnimatedViewPager
import io.armcha.ribble.presentation.base_mvp.base.BaseActivity
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

class AuthActivity : BaseActivity(), AuthMvpView {

    @Inject lateinit var mPresenter: AuthMvpPresenter<AuthMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

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
        val pager = ButterKnife.findById<AnimatedViewPager>(this, R.id.pager)
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
