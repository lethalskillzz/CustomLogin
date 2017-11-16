package com.lethalskillzz.nomoreqs.presentation.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.auth.AuthActivity
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import io.armcha.ribble.presentation.base_mvp.base.BaseActivity
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */


class SplashActivity : BaseActivity(), SplashMvpView {

    @Inject lateinit var mPresenter: SplashMvpPresenter<SplashMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        activityComponent!!.inject(this)

        setUnBinder(ButterKnife.bind(this))

        mPresenter!!.onAttach(this@SplashActivity)
    }


    override fun openNextActivity() {
        startActivity(AuthActivity.getStartIntent(this@SplashActivity))
        finish()
    }


    protected override fun onDestroy() {
        mPresenter!!.onDetach()
        super.onDestroy()
    }

    protected override fun setUp() {

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    override fun remove(fragment: BaseFragment) {

    }

}
