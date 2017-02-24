package lv.luhmirins.memorygame.wrappers

import com.google.android.things.contrib.driver.ht16k33.AlphanumericDisplay
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat

class Display(
    private val display: AlphanumericDisplay = RainbowHat.openDisplay()
) : AutoCloseable {

    init {
        display.setEnabled(true)
        display.clear()
    }

    fun show(text: String, alignRight: Boolean = false, padding: String = " ") {
        display.clear()

        if (alignRight) display.display(text.limitedSize().leftPad(padding))
        else display.display(text.limitedSize())
    }

    private fun String.limitedSize(): String {
        val trimmedText = this.trim()
        return if (trimmedText.length > 4) trimmedText.substring(0, 3) else trimmedText

    }

    private fun String.leftPad(ch: String = " ") = StringBuilder()
        .let { builder ->
            val length = 3 - this.length

            (0..length).forEach { builder.append(ch) }
            builder.append(this)
        }
        .toString()


    override fun close() {
        display.clear()
        display.close()
    }
}
