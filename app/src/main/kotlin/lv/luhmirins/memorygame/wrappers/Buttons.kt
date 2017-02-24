package lv.luhmirins.memorygame.wrappers

import com.google.android.things.contrib.driver.button.Button
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat

class Buttons(
    private val buttonA: Button = RainbowHat.openButton(RainbowHat.BUTTON_A),
    private val buttonB: Button = RainbowHat.openButton(RainbowHat.BUTTON_B),
    private val buttonC: Button = RainbowHat.openButton(RainbowHat.BUTTON_C)
) : AutoCloseable {


    fun onPressedA(action: () -> Unit) {
        buttonA.setOnButtonEventListener { button, pressed -> if (pressed) action() }
    }

    fun onPressedB(action: () -> Unit) {
        buttonB.setOnButtonEventListener { button, pressed -> if (pressed) action() }
    }

    fun onPressedC(action: () -> Unit) {
        buttonC.setOnButtonEventListener { button, pressed -> if (pressed) action() }
    }

    fun clearClickA() {
        buttonA.setOnButtonEventListener(null)
    }

    fun clearClickB() {
        buttonA.setOnButtonEventListener(null)
    }

    fun clearClickC() {
        buttonA.setOnButtonEventListener(null)
    }

    fun clearClickAll() {
        clearClickA()
        clearClickB()
        clearClickC()
    }

    override fun close() {
        buttonA.close()
        buttonB.close()
        buttonC.close()
    }

}
