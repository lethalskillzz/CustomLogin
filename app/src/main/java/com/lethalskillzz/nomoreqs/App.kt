package com.lethalskillzz.nomoreqs

import android.app.Application
import android.support.annotation.VisibleForTesting
import com.lethalskillzz.nomoreqs.util.AppLogger

/**
 * Created by ibrahimabdulkadir on 14/11/2017.
 */

class App : Application() {

    lateinit var component : PostsComponent
        @VisibleForTesting set

    override fun onCreate() {
        super.onCreate()
        instance = this

        if (BuildConfig.DEBUG) {
            AppLogger.init()
        }

        component = DaggerPostsComponent.builder()
                .postsModule(PostsModule(App.instance))
                .build()
    }

    companion object {
        lateinit var instance : App private set
    }
}