package com.lethalskillzz.nomoreqs.presentation.main

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.presentation.base.MvpPresenter

/**
 * Created by ibrahimabdulkadir on 20/11/2017.
 */

@PerActivity
interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V>