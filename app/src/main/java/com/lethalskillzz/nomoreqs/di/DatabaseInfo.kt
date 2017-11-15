package com.lethalskillzz.nomoreqs.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class DatabaseInfo
