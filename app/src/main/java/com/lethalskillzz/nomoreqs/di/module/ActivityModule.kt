package com.lethalskillzz.nomoreqs.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.lethalskillzz.nomoreqs.di.ActivityContext
import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.presentation.auth.AuthMvpPresenter
import com.lethalskillzz.nomoreqs.presentation.auth.AuthMvpView
import com.lethalskillzz.nomoreqs.presentation.auth.AuthPresenter
import com.lethalskillzz.nomoreqs.presentation.auth.login.LoginMvpPresenter
import com.lethalskillzz.nomoreqs.presentation.auth.login.LoginMvpView
import com.lethalskillzz.nomoreqs.presentation.auth.login.LoginPresenter
import com.lethalskillzz.nomoreqs.presentation.auth.signup.SignupMvpPresenter
import com.lethalskillzz.nomoreqs.presentation.auth.signup.SignupMvpView
import com.lethalskillzz.nomoreqs.presentation.auth.signup.SignupPresenter
import com.lethalskillzz.nomoreqs.presentation.splash.SplashMvpPresenter
import com.lethalskillzz.nomoreqs.presentation.splash.SplashMvpView
import com.lethalskillzz.nomoreqs.presentation.splash.SplashPresenter
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Module
class ActivityModule(private val mActivity: AppCompatActivity) {

    @Provides
    @ActivityContext
    internal fun provideContext(): Context = mActivity

    @Provides
    internal fun provideActivity(): AppCompatActivity = mActivity

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    @PerActivity
    internal fun provideSplashPresenter(
            presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> =
            presenter

    @Provides
    @PerActivity
    internal fun provideAuthPresenter(
            presenter: AuthPresenter<AuthMvpView>): AuthMvpPresenter<AuthMvpView> =
            presenter


    @Provides
    @PerActivity
    internal fun provideLoginPresenter(
            presenter: LoginPresenter<LoginMvpView>): LoginMvpPresenter<LoginMvpView> =
            presenter


    @Provides
    @PerActivity
    internal fun provideSignupPresenter(
            presenter: SignupPresenter<SignupMvpView>): SignupMvpPresenter<SignupMvpView> =
            presenter

    @Provides
    internal fun provideDividerItemDecoration(activity: AppCompatActivity): DividerItemDecoration =
            DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager =
            LinearLayoutManager(activity)


}