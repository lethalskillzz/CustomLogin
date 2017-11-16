package com.lethalskillzz.nomoreqs.presentation.auth

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.presentation.base.MvpPresenter

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@PerActivity
interface AuthMvpPresenter<V : AuthMvpView> : MvpPresenter<V>