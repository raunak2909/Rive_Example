package com.alphabet.rive_example_137

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import app.rive.runtime.kotlin.RiveAnimationView
import java.lang.Math.abs

class RiveAnimationFixedView(context: Context, attrs: AttributeSet?) : RiveAnimationView(context, attrs) {
    private var startX: Float = 0f
    private var startY: Float = 0f
    private val viewConfiguration: ViewConfiguration = ViewConfiguration.get(context)
    private val scaledTouchSlop: Int = viewConfiguration.scaledTouchSlop

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            startX = event.x
            startY = event.y
        } else if (event?.action == MotionEvent.ACTION_UP) {
            val endX = event.x
            val endY = event.y
            if (abs(endX - startX) < scaledTouchSlop && abs(endY - startY) < scaledTouchSlop) {
                performClick()
            }
        }
        return super.onTouchEvent(event)
    }
}