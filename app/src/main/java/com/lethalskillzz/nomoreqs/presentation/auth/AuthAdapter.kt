package com.lethalskillzz.nomoreqs.presentation.auth

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

class AuthAdapter(manager: FragmentManager, private val pager: AnimatedViewPager) : FragmentStatePagerAdapter(manager), AuthFragment.Callback {
    private var signUp: AuthFragment? = null
    private var logIn: AuthFragment? = null

    private val transformer: FlipTransformer

    init {
        transformer = FlipTransformer(160)
        this.pager.setDuration(200)
        this.pager.setPageTransformer(true, transformer)
    }

    override fun getItem(position: Int): AuthFragment {
        if (position == 0) {
            if (logIn == null) logIn = LogInFragment()
            logIn!!.setCallback(this)
            return logIn
        } else if (signUp == null) {
            signUp = SignUpFragment()
            signUp!!.setCallback(this)
        }
        return signUp
    }

    override fun remove(fragment: AuthFragment) {
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