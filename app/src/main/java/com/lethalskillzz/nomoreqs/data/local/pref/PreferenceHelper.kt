package com.lethalskillzz.nomoreqs.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import com.lethalskillzz.nomoreqs.di.ApplicationContext
import com.lethalskillzz.nomoreqs.util.AppConstants.PREFS_FILE_NAME
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

@Singleton
class PreferencesHelper @Inject
constructor(@ApplicationContext context: Context) {

    private val mSharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE)

    var isSynced: Boolean
        get() = mSharedPreferences.getBoolean(PREFERENCE_IS_SYNCED, false)
        set(flag) = mSharedPreferences.edit().putBoolean(PREFERENCE_IS_SYNCED, flag).apply()

    companion object {

        private val PREFERENCE_IS_SYNCED = "isSynced"
    }

}
