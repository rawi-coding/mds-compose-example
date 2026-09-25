package ch.sbb.appbakery.app.mdsexample.mds.composables.item.style

import androidx.compose.foundation.style.CustomStyle
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.StyleScope

interface SBBItemStyleScope : StyleScope

fun interface SBBItemStyle : CustomStyle<SBBItemStyleScope> {
    companion object : SBBItemStyle {
        override fun SBBItemStyleScope.applyStyle() {}
    }
}

fun SBBItemStyle.toStyle(): Style = Style {
    val scope = object : StyleScope by this, SBBItemStyleScope {}
    with(scope) { applyStyle() }
}
