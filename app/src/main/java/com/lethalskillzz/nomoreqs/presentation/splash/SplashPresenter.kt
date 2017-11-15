package com.lethalskillzz.nomoreqs.presentation.splash

import android.os.SystemClock
import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import com.lethalskillzz.nomoreqs.util.RxUtils
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

class SplashPresenter<V : SplashMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable), SplashMvpPresenter<V> {


    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)


        compositeDisposable.add(Observable.create<Any> { emitter ->
            SystemClock.sleep(SPLASH_TIME_OUT.toLong()) // simulate delay
            emitter.onNext(5)
            emitter.onComplete()
        }.compose(RxUtils.applySchedulers()).subscribe(Consumer<Any> { mvpView.openNextActivity() }))


    }

    companion object {

        private val TAG = "SplashPresenter"

        // Splash screen timeout
        private val SPLASH_TIME_OUT = 3000
    }


}
