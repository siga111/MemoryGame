package lv.luhmirins.memorygame

import android.util.Log

fun Any?.logD() {
    Log.d("MEMORY_GAME", this?.toString())
}

fun Any?.logE() {
    Log.e("MEMORY_GAME", this?.toString())
}

