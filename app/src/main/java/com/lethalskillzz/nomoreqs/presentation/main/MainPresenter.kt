package com.lethalskillzz.nomoreqs.presentation.main

import com.lethalskillzz.nomoreqs.data.AppRepository
import com.lethalskillzz.nomoreqs.data.model.User
import com.lethalskillzz.nomoreqs.presentation.base.BasePresenter
import com.lethalskillzz.nomoreqs.presentation.custom.navigation.NavigationState
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.emptyString
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by ibrahimabdulkadir on 20/11/2017.
 */

class MainPresenter<V : MainMvpView> @Inject
constructor(appRepository: AppRepository,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(appRepository, compositeDisposable),MainMvpPresenter<V> {


    private var isArcIcon = false
    private var user: User? = null
    private var isDrawerOpened = false
    private var activeTitle = emptyString
    private var state: NavigationState? = null
    private var currentNavigationSelectedItem = 0



    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        if (isArcIcon || isDrawerOpened) {
            mvpView?.setArcArrowState()
        } else {
            mvpView?.setArcHamburgerIconState()
        }
        mvpView?.setToolBarTitle(activeTitle)
        mvpView?.let {
            // mvpView?.updateDrawerInfo(it)
        }
     }


    override fun handleDrawerOpen() {
        if (!isArcIcon)
            mvpView?.setArcArrowState()
        isDrawerOpened = true
    }

    override fun handleDrawerClose() {
        if (!isArcIcon &&isDrawerOpened)
            mvpView?.setArcHamburgerIconState()
        isDrawerOpened = false
    }


    companion object {
        private val TAG = "MainPresenter"
    }
}
