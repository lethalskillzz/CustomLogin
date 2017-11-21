package com.lethalskillzz.nomoreqs.presentation.custom

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet


class AnimatedImageView(context: Context, attrs: AttributeSet? = null)
    : AppCompatImageView(context, attrs), AnimatedView {

    fun setAnimatedImage(newImage: Int, startDelay: Long = 0L) {
        changeImage(newImage, startDelay)
    }

    private fun changeImage(newImage: Int, startDelay: Long) {
        if (tag == newImage)
            return
        animate(view = this, startDelay = startDelay) {
            setImageResource(newImage)
            tag = newImage
        }
    }
}