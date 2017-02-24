package lv.luhmirins.memorygame

import android.app.Activity
import android.os.Bundle
import lv.luhmirins.memorygame.wrappers.Buttons
import lv.luhmirins.memorygame.wrappers.Display
import lv.luhmirins.memorygame.wrappers.LedStrip
import lv.luhmirins.memorygame.wrappers.Leds


class HomeActivity : Activity() {

    var buttons: Buttons? = null
    var ledStrip: LedStrip? = null
    var leds: Leds? = null
    var display: Display? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        leds = Leds().apply { allOff() }

        buttons = Buttons().apply {
            onPressedA {
                leds?.onlyA()
            }
            onPressedB {
                leds?.onlyB()
            }
            onPressedC {
                leds?.onlyC()
            }
        }

        ledStrip = LedStrip().apply {
            setColors(LedStrip.RAINBOW)
        }

        display = Display().apply {
            show("test")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        display?.close()
        leds?.close()
        buttons?.close()
        ledStrip?.close()
    }
}
