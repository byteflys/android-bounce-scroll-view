package com.android.library.bouncescrollview.commons.android

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

object ObjectEx {

    @OptIn(ExperimentalContracts::class)
    inline fun <T : Any> T?.isNull(): Boolean {
        contract {
            returns(true) implies (this@isNull == null)
            returns(false) implies (this@isNull != null)
        }
        return this == null
    }

    @OptIn(ExperimentalContracts::class)
    inline fun <T : Any> T?.isNotNull(): Boolean {
        contract {
            returns(true) implies (this@isNotNull != null)
            returns(false) implies (this@isNotNull == null)
        }
        return this != null
    }

    fun <T : Any> T?.ifNotNull(doOnNext: (T) -> Unit) {
        this?.let(doOnNext)
    }
}