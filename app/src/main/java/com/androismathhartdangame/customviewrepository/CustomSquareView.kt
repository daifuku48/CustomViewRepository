package com.androismathhartdangame.customviewrepository

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.Px

class CustomSquareView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): View(context, attrs, defStyleAttr){

    @Px
    var strokeWidth: Float = DEFAULT_STROKE_WIDTH
    @ColorInt
    var strokeColor: Int = DEFAULT_STROKE_COLOR
    @Px
    var cornerRadius: Float = DEFAULT_CORNER_RADIUS

    init {
        if (attrs != null){
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSquareView)
            strokeColor = typedArray.getColor(
                R.styleable.CustomSquareView_strokeColor,
                DEFAULT_STROKE_COLOR
            )
            strokeWidth = typedArray.getFloat(
                R.styleable.CustomSquareView_strokeWidth,
                DEFAULT_STROKE_WIDTH
            )
            cornerRadius = typedArray.getFloat(
                R.styleable.CustomSquareView_cornerRadius,
                DEFAULT_CORNER_RADIUS
            )
            typedArray.recycle()
        }
    }

    companion object {
        const val DEFAULT_CORNER_RADIUS = 0f
        const val DEFAULT_STROKE_WIDTH: Float = 1f
        const val DEFAULT_STROKE_COLOR = Color.BLACK
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }
}
