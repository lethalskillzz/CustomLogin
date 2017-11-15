package com.lethalskillzz.nomoreqs.di.component

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.di.module.ActivityModule
import com.lethalskillzz.nomoreqs.presentation.splash.SplashActivity
import dagger.Component

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: SplashActivity)
}
