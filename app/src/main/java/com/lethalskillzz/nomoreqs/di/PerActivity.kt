package com.lethalskillzz.nomoreqs.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity
