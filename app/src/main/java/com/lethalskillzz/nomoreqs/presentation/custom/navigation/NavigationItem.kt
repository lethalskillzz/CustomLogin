package com.lethalskillzz.nomoreqs.presentation.custom.navigation

import com.lethalskillzz.nomoreqs.R


data class NavigationItem(val item: NavigationId,
                          val icon: Int,
                          var isSelected: Boolean = false,
                          val itemIconColor: Int = R.color.navigation_item_color) {

    val name: String
        get() = item.name

    val id: NavigationId
        get() = item
}