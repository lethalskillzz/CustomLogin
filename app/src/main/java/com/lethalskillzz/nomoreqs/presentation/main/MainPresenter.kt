package com.lethalskillzz.nomoreqs.presentation.main

import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 20/11/2017.
 */

class MainPresenter<V : MainMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable),MainMvpPresenter<V> {


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)

    }

    companion object {
        private val TAG = "MainPresenter"
    }
}
