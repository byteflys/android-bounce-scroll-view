package com.android.library.bouncescrollview.commons.android

import android.graphics.Matrix

object MatrixEx {

    fun Matrix.translate(dx: Number, dy: Number) = apply {
        postTranslate(dx.toFloat(), dy.toFloat())
    }

    fun Matrix.scale(sx: Number, sy: Number) = apply {
        postScale(sx.toFloat(), sy.toFloat())
    }

    fun Matrix.rotate(degree: Number) = apply {
        postRotate(degree.toFloat())
    }

    fun Matrix.skew(
        kx: Number,
        ky: Number,
        px: Number = 0f,
        py: Number = 0f,
    ) = apply {
        postSkew(kx.toFloat(), ky.toFloat(), px.toFloat(), py.toFloat())
    }
}