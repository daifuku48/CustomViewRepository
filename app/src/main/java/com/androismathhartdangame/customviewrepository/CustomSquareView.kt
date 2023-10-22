package com.androismathhartdangame.customviewrepository

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
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
    private var strokeWidth: Float = DEFAULT_STROKE_WIDTH
    @ColorInt
    private var strokeColor: Int = DEFAULT_STROKE_COLOR
    @Px
    private var cornerRadius: Float = DEFAULT_CORNER_RADIUS
    private var rect = Rect()
    private val maskPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var resultBitmap: Bitmap

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

    override fun onSizeChanged(width: Int, height: Int, oldwidth: Int, oldheight: Int) {
        super.onSizeChanged(width, height, oldwidth, oldheight)
        if (width == 0)
            return
        rect = Rect(0, 0, width, height)

        prepareBitmap(width, height)
    }

    private fun prepareBitmap(width: Int, height: Int) {
        resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    }

    companion object {
        const val DEFAULT_CORNER_RADIUS = 0f
        const val DEFAULT_STROKE_WIDTH: Float = 1f
        const val DEFAULT_STROKE_COLOR = Color.BLACK
    }

    override fun onDraw(canvas: Canvas?) {


        canvas.drawBitmap()

    }
}
