package com.android.library.bouncescrollview.commons.android

import android.graphics.Rect
import android.view.View
import com.android.library.bouncescrollview.commons.android.RectEx.getRect
import com.android.library.bouncescrollview.commons.android.RectEx.getRectF

internal object ViewEx {

    fun View.layout(rect: Rect) = layout(rect.left, rect.top, rect.right, rect.bottom)

    fun View.getAvailableRect() = getRect(
        paddingLeft,
        paddingTop,
        measuredWidth - paddingRight,
        measuredHeight - paddingBottom
    )

    fun View.getAvailableRectF() = getRectF(
        paddingLeft,
        paddingTop,
        measuredWidth - paddingRight,
        measuredHeight - paddingBottom
    )

    fun createCornerRadius(
        radius: Number
    ) = createCornerRadius(radius, radius, radius, radius)

    fun createCornerRadius(
        topLeftRadius: Number,
        topRightRadius: Number,
        bottomLeftRadius: Number,
        bottomRightRadius: Number
    ) = createCornerRadius(
        topLeftRadius, topLeftRadius,
        topRightRadius, topRightRadius,
        bottomLeftRadius, bottomLeftRadius,
        bottomRightRadius, bottomRightRadius
    )

    fun createCornerRadius(
        topLeftRadiusX: Number, topLeftRadiusY: Number,
        topRightRadiusX: Number, topRightRadiusY: Number,
        bottomLeftRadiusX: Number, bottomLeftRadiusY: Number,
        bottomRightRadiusX: Number, bottomRightRadiusY: Number
    ) = floatArrayOf(
        topLeftRadiusX.toFloat(), topLeftRadiusY.toFloat(),
        topRightRadiusX.toFloat(), topRightRadiusY.toFloat(),
        bottomRightRadiusX.toFloat(), bottomRightRadiusY.toFloat(),
        bottomLeftRadiusX.toFloat(), bottomLeftRadiusY.toFloat()
    )
}