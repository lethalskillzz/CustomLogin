package com.lethalskillzz.nomoreqs.presentation.main

import com.lethalskillzz.nomoreqs.data.model.User
import com.lethalskillzz.nomoreqs.presentation.base.MvpView

/**
 * Created by ibrahimabdulkadir on 20/11/2017.
 */

interface MainMvpView : MvpView {

    fun setArcArrowState()

    fun setArcHamburgerIconState()

    fun setToolBarTitle(title: String)

    fun updateDrawerInfo(user: User)

    fun checkNavigationItem(position: Int)

}