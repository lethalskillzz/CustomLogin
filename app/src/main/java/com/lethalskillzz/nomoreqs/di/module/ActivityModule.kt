package com.lethalskillzz.nomoreqs.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.lethalskillzz.nomoreqs.di.ActivityContext
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
    internal fun provideContext(): Context {
        return mActivity
    }

    @Provides
    internal fun provideActivity(): AppCompatActivity {
        return mActivity
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }


    @Provides
    internal fun provideDividerItemDecoration(activity: AppCompatActivity): DividerItemDecoration {
        return DividerItemDecoration(activity, LinearLayoutManager.VERTICAL)
    }

    @Provides
    internal fun provideLinearLayoutManager(activity: AppCompatActivity): LinearLayoutManager {
        return LinearLayoutManager(activity)
    }


}