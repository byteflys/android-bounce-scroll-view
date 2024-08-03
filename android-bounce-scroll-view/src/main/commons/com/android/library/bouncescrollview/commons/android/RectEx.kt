package com.android.library.bouncescrollview.commons.android

import android.graphics.Rect
import android.graphics.RectF

object RectEx {

    fun RectF.toRect(): Rect {
        val src = this
        val dst = Rect()
        dst.left = src.left.toInt()
        dst.right = src.right.toInt()
        dst.top = src.top.toInt()
        dst.bottom = src.bottom.toInt()
        return dst
    }

    fun Rect.toRectF(): RectF {
        val src = this
        val dst = RectF()
        dst.left = src.left.toFloat()
        dst.right = src.right.toFloat()
        dst.top = src.top.toFloat()
        dst.bottom = src.bottom.toFloat()
        return dst
    }

    fun getRect(left: Number, top: Number, right: Number, bottom: Number): Rect {
        return Rect(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())
    }

    fun getRectF(left: Number, top: Number, right: Number, bottom: Number): RectF {
        return RectF(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat())
    }
}