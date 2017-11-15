package com.lethalskillzz.nomoreqs.di.component

import android.app.Application
import android.content.Context
import com.lethalskillzz.nomoreqs.App
import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.di.ApplicationContext
import com.lethalskillzz.nomoreqs.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    val appRepository: AppRepository

    fun inject(app: App)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}