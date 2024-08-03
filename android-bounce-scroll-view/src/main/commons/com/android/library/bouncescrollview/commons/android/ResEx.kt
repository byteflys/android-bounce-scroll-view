package com.android.library.bouncescrollview.commons.android

import android.content.Context
import android.view.View

internal object ResEx {

    fun Context.color(colorResId: Int) = resources.getColor(colorResId, null)

    fun Context.drawable(drawableResId: Int) = resources.getDrawable(drawableResId, null)

    fun Context.dimen(dimenResId: Int) = resources.getDimension(dimenResId)

    fun Context.string(stringResId: Int) = resources.getString(stringResId)

    fun View.color(colorResId: Int) = context.color(colorResId)

    fun View.drawable(drawableResId: Int) = context.drawable(drawableResId)

    fun View.dimen(dimenResId: Int) = context.dimen(dimenResId)

    fun View.string(stringResId: Int) = context.string(stringResId)
}