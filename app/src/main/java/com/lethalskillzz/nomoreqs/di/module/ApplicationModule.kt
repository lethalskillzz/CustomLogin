package com.lethalskillzz.nomoreqs.di.module

import android.app.Application
import android.content.Context
import com.lethalskillzz.nomoreqs.data.AppDataSource
import com.lethalskillzz.nomoreqs.data.local.AppLocalDataSource
import com.lethalskillzz.nomoreqs.data.local.pref.PreferencesHelper
import com.lethalskillzz.nomoreqs.data.remote.AppRemoteDataSource
import com.lethalskillzz.nomoreqs.di.ApplicationContext
import com.lethalskillzz.nomoreqs.di.Local
import com.lethalskillzz.nomoreqs.di.Remote
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Singleton
    @Provides
    @Local
    internal fun provideAppLocalDataSource(): AppDataSource {
        return AppLocalDataSource()
    }

    @Singleton
    @Provides
    @Remote
    internal fun provideAppRemoteDataSource(): AppDataSource {
        return AppRemoteDataSource()
    }


    @Provides
    internal fun provideScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Singleton
    @Provides
    internal fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }
}

