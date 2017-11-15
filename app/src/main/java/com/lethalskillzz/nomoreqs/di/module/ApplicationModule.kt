package com.lethalskillzz.nomoreqs.di.module

import android.app.Application
import android.content.Context
import com.lethalskillzz.nomoreqs.di.ApplicationContext
import com.lethalskillzz.nomoreqs.di.DatabaseInfo
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
    internal fun provideContext(): Context = mApplication

    @Provides
    internal fun provideApplication(): Application = mApplication


    @Provides
    internal fun provideScheduler(): Scheduler = Schedulers.io()

    @Singleton
    @Provides
    internal fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }
}
