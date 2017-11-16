package com.lethalskillzz.nomoreqs.presentation.auth

import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

class AuthPresenter<V : AuthMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable), AuthMvpPresenter<V> {


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

    }

    companion object {
        private val TAG = "AuthPresenter"
    }


}
