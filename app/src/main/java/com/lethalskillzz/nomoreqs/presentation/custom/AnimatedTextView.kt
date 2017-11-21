package com.lethalskillzz.nomoreqs.presentation.custom

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet



class AnimatedTextView (context: Context, attrs: AttributeSet? = null)
    : AppCompatTextView(context, attrs), AnimatedView {

    fun setAnimatedText(text: CharSequence, startDelay: Long = 0L) {
        changeText(text, startDelay)
    }

    private fun changeText(newText: CharSequence, startDelay: Long) {
        if (text == newText)
            return
        animate(view = this, startDelay = startDelay) {
            text = newText
        }
    }
}
