package lv.luhmirins.memorygame.wrappers

import android.graphics.Color
import android.support.annotation.IntRange
import com.google.android.things.contrib.driver.apa102.Apa102
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat

class LedStrip(
    val strip: Apa102 = Apa102(RainbowHat.BUS_LEDSTRIP, Apa102.Mode.BGR)
) : AutoCloseable {

    companion object {
        val OFF = 0
        val COLORS_OFF = intArrayOf(OFF, OFF, OFF, OFF, OFF, OFF, OFF)

        val VIOLET = Color.rgb(127, 0, 127)
        val INDIGO = Color.rgb(64, 0, 127)
        val BLUE = Color.rgb(0, 0, 127)
        val GREEN = Color.rgb(0, 127, 0)
        val YELLOW = Color.rgb(127, 127, 0)
        val ORANGE = Color.rgb(127, 64, 0)
        val RED = Color.rgb(127, 0, 0)

        val RAINBOW = intArrayOf(RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET)
    }

    init {
        clear()
    }

    fun clear() {
        strip.write(COLORS_OFF)
    }

    fun setColors(colors: IntArray, @IntRange(from = 0, to = 16) brightness: Int = 1) {
        val dif = 7 - colors.size

        val result = colors.toMutableList()
        (0..dif).forEach { result.add(OFF) }

        strip.let {
            it.setBrightness(brightness)
            it.write(result.toIntArray())
            it.write(COLORS_OFF)
        }
    }

    fun setAllTo(color: Int) {
        setColors(intArrayOf(color, color, color, color, color, color, color))
    }

    override fun close() {
        strip.close()
    }

}
