package com.lethalskillzz.nomoreqs.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

object NetworkUtils {

    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}// This utility class is not publicly instantiable
