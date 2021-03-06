package com.lethalskillzz.nomoreqs

import android.app.Application
import com.facebook.stetho.Stetho
import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.di.component.ApplicationComponent
import com.lethalskillzz.nomoreqs.di.component.DaggerApplicationComponent
import com.lethalskillzz.nomoreqs.di.module.ApplicationModule
import com.lethalskillzz.nomoreqs.util.AppLogger
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 14/11/2017.
 */

class App : Application() {

    @Inject
    lateinit var mAppRepository: AppRepository

    // Needed to replace the component with a test specific one
    var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this)).build()

        component!!.inject(this)

        if (BuildConfig.DEBUG) {
            AppLogger.init()
            Stetho.initializeWithDefaults(this)
        }

    }

}