package com.onkarnene.cavista.challenge.views.widgets

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.ceil

/**
 * Maintains aspect ratio of the image with respect to the width.
 * Height may be varied as per screen resolution.
 * Width is fixed i.e. Screen's width.
 */
class ResizableImageView(
		context: Context,
		attributeSet: AttributeSet
) : AppCompatImageView(context, attributeSet) {
	
	override fun onMeasure(
			widthMeasureSpec: Int,
			heightMeasureSpec: Int
	) {
		val d: Drawable? = drawable
		if (d != null) {
			val width: Int = MeasureSpec.getSize(widthMeasureSpec)
			val height: Int = ceil(width.toFloat() * d.intrinsicHeight.toFloat() / d.intrinsicWidth.toFloat()).toInt()
			setMeasuredDimension(width, height)
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec)
		}
	}
}