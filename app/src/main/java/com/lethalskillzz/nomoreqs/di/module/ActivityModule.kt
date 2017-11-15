package com.lethalskillzz.nomoreqs.di.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.lethalskillzz.nomoreqs.di.ActivityContext
import com.lethalskillzz.nomoreqs.di.PerActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import java.util.ArrayList

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
    @PerActivity
    internal fun provideSplashPresenter(
            presenter: SplashPresenter<SplashMvpView>): SplashMvpPresenter<SplashMvpView> {
        return presenter
    }


    @Provides
    @PerActivity
    internal fun provideMasterPresenter(
            presenter: MasterPresenter<MasterMvpView>): MasterMvpPresenter<MasterMvpView> {
        return presenter
    }


    @Provides
    @PerActivity
    internal fun provideDetailPresenter(
            presenter: DetailPresenter<DetailMvpView>): DetailMvpPresenter<DetailMvpView> {
        return presenter
    }


    @Provides
    internal fun provideMasterAdapter(): MasterAdapter {
        return MasterAdapter(ArrayList<E>(0))
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