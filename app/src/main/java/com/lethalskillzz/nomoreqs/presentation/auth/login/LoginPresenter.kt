package com.lethalskillzz.nomoreqs.presentation.auth.login

import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 16/11/2017.
 */

class LoginPresenter<V : LoginMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable),LoginMvpPresenter<V> {


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

    }

    companion object {
        private val TAG = "LoginPresenter"
    }


}
