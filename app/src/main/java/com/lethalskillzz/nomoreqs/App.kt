package com.lethalskillzz.nomoreqs

import android.app.Application
import android.content.Context
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 14/11/2017.
 */

class App : Application() {

    @Inject
    internal var mAppRepository: AppRepository? = null


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