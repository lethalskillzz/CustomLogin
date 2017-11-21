package com.lethalskillzz.nomoreqs.presentation.custom

import android.view.View
import com.lethalskillzz.nomoreqs.presentation.custom.utils.AnimationUtils

interface AnimatedView {

    fun <V : View> animate(view: V, duration: Long = 170, startDelay: Long, acton: V.() -> Unit) {
        val scaleFactor = 0.75f
        with(view) {
            clearAnimation()
            animate()
                    .alpha(0f)
                    .scaleX(scaleFactor)
                    .setDuration(duration)
                    .withLayer()
                    .setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR)
                    .setStartDelay(startDelay)
                    .withEndAction {
                        acton(view)
                        scaleX = scaleFactor
                        animate()
                                .scaleX(1f)
                                .alpha(1f)
                                .setListener(null)
                                .withLayer()
                                .setDuration(duration)
                                .start()
                    }
                    .start()
        }
    }
}