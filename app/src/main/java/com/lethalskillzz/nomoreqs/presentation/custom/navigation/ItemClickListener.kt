package com.lethalskillzz.nomoreqs.presentation.custom.navigation

interface ItemClickListener {

    operator fun invoke(item: NavigationItem, position: Int)
}