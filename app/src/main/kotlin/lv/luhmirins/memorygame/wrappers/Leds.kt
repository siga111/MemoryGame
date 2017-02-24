package lv.luhmirins.memorygame.wrappers

import com.google.android.things.contrib.driver.rainbowhat.RainbowHat
import com.google.android.things.pio.Gpio

class Leds(
    private val ledA: Gpio = RainbowHat.openLed(RainbowHat.LED_RED),
    private val ledB: Gpio = RainbowHat.openLed(RainbowHat.LED_GREEN),
    private val ledC: Gpio = RainbowHat.openLed(RainbowHat.LED_BLUE)
) : AutoCloseable {

    var onA: Boolean
        get() = ledA.value
        set(value) {
            ledA.value = value
        }

    var onB: Boolean
        get() = ledB.value
        set(value) {
            ledB.value = value
        }

    var onC: Boolean
        get() = ledC.value
        set(value) {
            ledC.value = value
        }

    fun toggleA() {
        onA = !onA
    }

    fun toggleB() {
        onB = !onB
    }

    fun toggleC() {
        onC = !onC
    }


    fun onlyA() {
        allOff()
        onA = true
    }

    fun onlyB() {
        allOff()
        onB = true
    }

    fun onlyC() {
        allOff()
        onC = true
    }

    fun allOn() {
        onA = true
        onB = true
        onC = true
    }

    fun allOff() {
        onA = false
        onB = false
        onC = false
    }

    override fun close() {
        allOff()
        ledA.close()
        ledB.close()
        ledC.close()
    }
}
