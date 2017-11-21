package com.lethalskillzz.nomoreqs.presentation.auth.signup

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.presentation.base.MvpPresenter

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

@PerActivity
interface SignupMvpPresenter<V : SignupMvpView> : MvpPresenter<V> {

    fun signupUser(email: String, password: String)

}