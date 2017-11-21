package com.lethalskillzz.nomoreqs.presentation.custom

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lethalskillzz.nomoreqs.R
import com.lethalskillzz.nomoreqs.presentation.custom.utils.extensions.takeColor

class ArcView constructor(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val SHADOW_OFFSET = 15F
    private val START_ANGLE = 270F
    private val SWEEP_ANGLE = 180F

    private val path = Path()
    private val rect = RectF()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val arcStartPoint = 2.5F

    init {
        setBackgroundColor(Color.TRANSPARENT)
        with(paint) {
            color = context takeColor R.color.colorAccent
            style = Paint.Style.FILL
            strokeCap = Paint.Cap.ROUND
            isDither = true
            setShadowLayer(SHADOW_OFFSET, 0F, 4F, Color.GRAY)
        }
        setLayerType(LAYER_TYPE_SOFTWARE, paint)
    }

    override fun onDraw(canvas: Canvas) {
        val width = width.toFloat() - SHADOW_OFFSET
        val height = height.toFloat() - SHADOW_OFFSET
        rect.set(width / arcStartPoint, SHADOW_OFFSET, width, height)
        with(path) {
            val halfWidth = width / 2
            lineTo(halfWidth + halfWidth / arcStartPoint, SHADOW_OFFSET)
            addArc(rect, START_ANGLE, SWEEP_ANGLE)
            lineTo(0F, height)
            lineTo(0F, SHADOW_OFFSET)
        }
        canvas.drawPath(path, paint)
    }
}
