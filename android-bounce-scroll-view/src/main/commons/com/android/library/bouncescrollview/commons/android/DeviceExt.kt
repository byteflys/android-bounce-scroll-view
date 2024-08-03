package com.android.library.bouncescrollview.commons.android

import android.util.DisplayMetrics
import android.util.Size
import android.view.WindowManager

object DeviceExt {

    fun getScreenContentSize(): Size {
        val manager = AndroidGlobal.appContext.getSystemService(WindowManager::class.java)
        val dm = DisplayMetrics()
        manager.defaultDisplay.getMetrics(dm)
        return Size(dm.widthPixels, dm.heightPixels)
    }

    fun screenContentWidth() = getScreenContentSize().width

    fun screenContentHeight() = getScreenContentSize().height
}