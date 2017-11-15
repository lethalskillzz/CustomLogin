package com.lethalskillzz.nomoreqs.di.component

import com.lethalskillzz.nomoreqs.di.PerActivity
import com.lethalskillzz.nomoreqs.di.module.ActivityModule
import dagger.Component

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {


}