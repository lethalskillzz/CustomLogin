package com.lethalskillzz.nomoreqs.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.lethalskillzz.nomoreqs.di.ActivityContext
import com.lethalskillzz.nomoreqs.di.PerActivity
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
    internal fun provideDividerItemDecoration(activity: AppCompatActivity): DividerItemDecoration =
            DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager =
            LinearLayoutManager(activity)


}