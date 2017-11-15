package com.lethalskillzz.nomoreqs.presentation.base

import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.data.AppRepository
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */


/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
class BasePresenter<V : MvpView> @Inject
constructor(val appRepository: AppRepository,
            val compositeDisposable: CompositeDisposable) : MvpPresenter<V> {

    var mvpView: V? = null
        private set

    val isViewAttached: Boolean
        get() = mvpView != null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        compositeDisposable.dispose()
        mvpView = null
    }

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpViewNotAttachedException()
    }

    override fun handleApiError(e: HttpException) {

        if (e?.message == null) {
            mvpView!!.onError(R.string.error_api_retry)
            return
        }

    }


    class MvpViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(MvpView) before" + " requesting data to the Presenter")

    companion object {

        private val TAG = "BasePresenter"
    }
}