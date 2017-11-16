package com.lethalskillzz.nomoreqs.presentation.auth.login

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.presentation.base.MvpPresenter

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

@PerActivity
interface LoginMvpPresenter<V : LoginMvpView> : MvpPresenter<V>