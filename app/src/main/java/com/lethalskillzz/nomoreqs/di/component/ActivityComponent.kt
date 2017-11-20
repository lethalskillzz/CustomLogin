package com.lethalskillzz.nomoreqs.di.component

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.di.module.ActivityModule
import com.lethalskillzz.nomoreqs.presentation.auth.AuthActivity
import com.lethalskillzz.nomoreqs.presentation.auth.login.LoginFragment
import com.lethalskillzz.nomoreqs.presentation.auth.signup.SignupFragment
import com.lethalskillzz.nomoreqs.presentation.main.MainActivity
import com.lethalskillzz.nomoreqs.presentation.splash.SplashActivity
import dagger.Component

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(activity: SplashActivity)
    fun inject(activity: AuthActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: SignupFragment)
    fun inject(activity: MainActivity)
}
