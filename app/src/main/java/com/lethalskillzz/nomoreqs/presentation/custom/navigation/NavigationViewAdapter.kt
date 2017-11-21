package com.lethalskillzz.nomoreqs.presentation.custom.navigation

import android.view.View
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.takeColor
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.tint
import kotlinx.android.synthetic.main.navigation_view_item.view.*


class NavigationViewAdapter constructor(navigationItemList: MutableList<NavigationItem>,
                                        private var itemClickListener: ItemClickListener?)
    : AbstractAdapter<NavigationItem>(navigationItemList, R.layout.navigation_view_item) {

    override fun onItemClick(itemView: View, position: Int) {
        itemClickListener?.let {
            it(itemList[position], position)
        }
    }

    override fun View.bind(item: NavigationItem) {
        itemText.text = item.name
        itemIcon.setImageResource(item.icon)
        itemIcon.tint(item.itemIconColor)
        if (item.isSelected) {
            itemText.setTextColor(context.takeColor(R.color.colorAccent))
        } else {
            itemText.setTextColor(context.takeColor(R.color.blue_gray))
        }
    }
}