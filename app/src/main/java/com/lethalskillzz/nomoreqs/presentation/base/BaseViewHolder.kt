package com.lethalskillzz.nomoreqs.presentation.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by ibrahimabdulkadir on 15/11/2017.
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var currentPosition: Int = 0
        private set

    protected abstract fun clear()

    fun onBind(position: Int) {
        currentPosition = position
        clear()
    }
}
