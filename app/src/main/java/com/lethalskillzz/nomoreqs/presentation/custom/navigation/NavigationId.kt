package com.lethalskillzz.nomoreqs.presentation.custom.navigation

import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.emptyString


sealed class NavigationId(val name: String = emptyString, val fullName: String = emptyString) {

    object ABOUT : NavigationId("APP INFO")
    object LOG_OUT : NavigationId("LOG OUT")
}