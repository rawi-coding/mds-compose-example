package ch.sbb.appbakery.app.mdsexample.mds.composables.item

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.contentPadding
import androidx.compose.foundation.style.disabled
import androidx.compose.material3.Typography
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColorScheme
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColors

internal fun defaultSBBItemStyle(colorScheme: SBBColorScheme, isDarkMode: Boolean): Style = Style {
    contentColor(colorScheme.textPrimary)
    background(colorScheme.backgroundContent)
    shape(RoundedCornerShape(16.dp))
    minHeight(56.dp)
    textStyle(Typography().titleMedium)

    contentPadding(16.dp)

    disabled {
        background(if (isDarkMode) SBBColors.iron else SBBColors.cement)
    }
}
