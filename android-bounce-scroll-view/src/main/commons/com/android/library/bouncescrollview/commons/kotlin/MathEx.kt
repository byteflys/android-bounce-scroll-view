package com.android.library.bouncescrollview.commons.kotlin

internal object MathEx {

    fun findInsertIndexAsc(list: List<Int>, value: Int): Int {
        for (i in list.size downTo 1) {
            val item = list[i - 1]
            if (item == value)
                return -1
            if (item < value)
                return i
        }
        return 0
    }
}