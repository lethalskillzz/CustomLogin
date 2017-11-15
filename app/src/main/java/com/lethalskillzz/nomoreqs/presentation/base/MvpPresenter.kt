package com.lethalskillzz.nomoreqs.presentation.base

import retrofit2.HttpException

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
interface MvpPresenter<V : MvpView> {

    fun onAttach(mvpView: V)

    fun onDetach()

    fun handleApiError(e: HttpException)
}
