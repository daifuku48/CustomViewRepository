package com.androismathhartdangame.customviewrepository

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CustomSquareView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var strokeWidth: Float = DEFAULT_STROKE_WIDTH
    private var strokeColor: Int = DEFAULT_STROKE_COLOR
    private var cornerRadius: Float = DEFAULT_CORNER_RADIUS
    private var rect = RectF()
    private var strokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object {
        const val DEFAULT_CORNER_RADIUS = 0f
        const val DEFAULT_STROKE_WIDTH = 2f
        const val DEFAULT_STROKE_COLOR = Color.BLACK
    }

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomSquareView)
            strokeColor = typedArray.getColor(
                R.styleable.CustomSquareView_stroke_color,
                DEFAULT_STROKE_COLOR
            )
            strokeWidth = typedArray.getDimension(
                R.styleable.CustomSquareView_stroke_width,
                DEFAULT_STROKE_WIDTH
            )
            cornerRadius = typedArray.getDimension(
                R.styleable.CustomSquareView_corner_radius,
                DEFAULT_CORNER_RADIUS
            )
            strokePaint.color = strokeColor
            strokePaint.style = Paint.Style.STROKE
            strokePaint.strokeWidth = strokeWidth
            typedArray.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        val height = MeasureSpec.getSize(heightMeasureSpec).toFloat()
        val stroke = strokeWidth / 2
        rect.set(
            stroke,
            stroke,
            width - stroke,
            height - stroke
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRoundRect(rect, cornerRadius, cornerRadius, strokePaint)
    }
}
