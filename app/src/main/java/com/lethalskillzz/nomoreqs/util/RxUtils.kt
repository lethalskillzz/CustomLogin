package com.lethalskillzz.nomoreqs.util

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

object RxUtils {

    fun <T> Observable<T>.applySchedulers(): Observable<T> =
            subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread())
}




