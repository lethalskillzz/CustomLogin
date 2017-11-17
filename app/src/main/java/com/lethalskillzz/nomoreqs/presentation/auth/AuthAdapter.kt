package com.lethalskillzz.nomoreqs.presentation.auth

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.lethalskillzz.nomoreqs.presentation.auth.login.LoginFragment
import com.lethalskillzz.nomoreqs.presentation.auth.signup.SignupFragment
import com.lethalskillzz.nomoreqs.presentation.base.BaseFragment
import com.lethalskillzz.nomoreqs.presentation.custom.flip.AnimatedViewPager
import com.lethalskillzz.nomoreqs.presentation.custom.flip.FlipTransformer

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

class AuthAdapter(manager: FragmentManager, private val pager: AnimatedViewPager) :
        FragmentStatePagerAdapter(manager), BaseFragment.AuthCallback {


    private var signUp: BaseFragment? = null
    private var logIn: BaseFragment? = null

    private val transformer: FlipTransformer

    init {
        transformer = FlipTransformer(160)
        this.pager.setDuration(200)
        this.pager.setPageTransformer(true, transformer)
    }

    override fun getItem(position: Int): BaseFragment {
        if (position == 0) {
            if (logIn == null) logIn = LoginFragment()
            logIn!!.setAuthCallback(this)
            return logIn as BaseFragment
        } else if (signUp == null) {
            signUp = SignupFragment()
            signUp!!.setAuthCallback(this)
        }
        return signUp as BaseFragment
    }

    override fun remove(fragment: BaseFragment) {
        if (logIn === fragment) {
            transformer.setMovingForward(true)
            pager.setCurrentItem(1, true)
            signUp!!.fireAnimation()
        } else {
            transformer.setMovingForward(false)
            pager.setCurrentItem(0, true)
            logIn!!.fireAnimation()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}