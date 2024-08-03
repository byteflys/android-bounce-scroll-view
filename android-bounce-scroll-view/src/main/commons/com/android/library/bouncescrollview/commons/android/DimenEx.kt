package com.android.library.bouncescrollview.commons.android

import android.content.Context
import android.view.View

internal object DimenEx {

    fun Context.dp2Px(dp: Number): Float {
        val scale = resources.displayMetrics.density
        return dp.toFloat() * scale + 0.5F
    }

    fun Context.px2Dp(px: Number): Float {
        val scale = resources.displayMetrics.density
        return px.toFloat() / scale + 0.5F
    }

    fun View.dp2Px(dp: Number) = context.dp2Px(dp)

    fun View.px2Dp(px: Number) = context.px2Dp(px)
}