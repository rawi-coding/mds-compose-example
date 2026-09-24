package ch.sbb.appbakery.app.mdsexample.mds.composables.button

import androidx.compose.foundation.style.CustomStyle
import androidx.compose.foundation.style.MutableStyleState
import androidx.compose.foundation.style.StyleScope
import androidx.compose.foundation.style.StyleStateKey

// TODO: custom style properties like iconColor?
//fun StyleScope.outlinedBackground(color: Color) {
//    border(1.dp, color)
//    background(color)
//}

interface SBBButtonStyleScope : StyleScope

fun interface SBBButtonStyle : CustomStyle<SBBButtonStyleScope> {
    companion object : SBBButtonStyle {
        override fun SBBButtonStyleScope.applyStyle() {}
    }
}

enum class SBBButtonState {
    Default,
    Loading,
}

val buttonStateKey = StyleStateKey(SBBButtonState.Default)

var MutableStyleState.buttonState
    get() = this[buttonStateKey]
    set(value) {
        this[buttonStateKey] = value
    }

// TODO: Why does SBBButtonStyleScope not work? https://youtu.be/e-wlF3cmJms?t=1451
fun StyleScope.loading(block: () -> Unit) {
    state(buttonStateKey, block) { key, state -> state[key] == SBBButtonState.Loading }
}
