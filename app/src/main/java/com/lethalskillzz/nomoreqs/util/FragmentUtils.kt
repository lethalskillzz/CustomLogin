package com.lethalskillzz.nomoreqs.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

object FragmentUtils {

    fun addFragmentTo(fragmentManager: FragmentManager,
                      fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()
    }

    fun replaceFragmentIn(fragmentManager: FragmentManager,
                          fragment: Fragment, frameId: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)
        transaction.commit()
    }
}// This utility class is not publicly instantiable
