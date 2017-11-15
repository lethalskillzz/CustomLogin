package com.lethalskillzz.nomoreqs.data

import android.content.Context
import com.lethalskillzz.nomoreqs.data.local.pref.PreferencesHelper
import com.lethalskillzz.nomoreqs.di.ApplicationContext
import com.lethalskillzz.nomoreqs.di.Local
import com.lethalskillzz.nomoreqs.di.Remote
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Singleton
class AppRepository @Inject
constructor(
        @param:ApplicationContext private val mContext: Context,
        @param:Remote private val mAppRemoteDataSource: AppDataSource,
        @param:Local private val mAppLocalDataSource: AppDataSource,
        private val mPreferencesHelper: PreferencesHelper) : AppDataSource {


}
