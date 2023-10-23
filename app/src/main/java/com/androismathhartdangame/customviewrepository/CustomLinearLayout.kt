package com.androismathhartdangame.customviewrepository

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding

class CustomLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    fun addItem(item: String) {
        val textView = TextView(context)
        textView.text = item
        textView.textSize = 18f
        textView.setBackgroundColor(resources.getColor(R.color.black, context.theme))
        textView.setTextColor(resources.getColor(R.color.white, context.theme))
        textView.setPadding(4)
        addView(textView)
    }
}