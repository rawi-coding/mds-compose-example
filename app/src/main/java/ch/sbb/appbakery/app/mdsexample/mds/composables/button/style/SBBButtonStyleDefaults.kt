package ch.sbb.appbakery.app.mdsexample.mds.composables.button.style

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.animate
import androidx.compose.foundation.style.disabled
import androidx.compose.foundation.style.pressed
import androidx.compose.foundation.style.then
import androidx.compose.material3.Typography
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColorScheme
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColors

internal val baseButtonStyle = Style {
    height(44.dp)
    textStyle(Typography().bodyMedium)
    shape(RoundedCornerShape(22.dp))
}

// TODO: Why does contentColor have no effect
internal fun defaultSBBPrimaryButtonStyle(
    colorScheme: SBBColorScheme,
    isDarkMode: Boolean
): Style = baseButtonStyle then Style {
    contentColor(SBBColors.white)
    background(colorScheme.primary)

    pressed {
        animate {
            background(colorScheme.primary125)
        }
    }

    disabled {
        animate {
            background(if (isDarkMode) SBBColors.iron else SBBColors.graphite)
            contentColor(if (isDarkMode) SBBColors.smoke else SBBColors.white)
        }
    }

    loading {
        animate {
            background(if (isDarkMode) SBBColors.iron else SBBColors.graphite)
            contentColor(if (isDarkMode) SBBColors.smoke else SBBColors.white)
        }
    }
}

internal fun defaultSBBSecondaryButtonStyle(
    colorScheme: SBBColorScheme,
    isDarkMode: Boolean
): Style = baseButtonStyle then Style {
    contentColor(colorScheme.primary)
    background(if (isDarkMode) SBBColors.iron else SBBColors.white)
    borderColor(colorScheme.primary)
    borderWidth(1.dp)

    pressed {
        animate {
            background(if (isDarkMode) SBBColors.charcoal else SBBColors.graphite)
        }
    }

    // TODO: Is it possible to combine multiple states? disabled and loading are identical
    disabled {
        animate {
            background(if (isDarkMode) SBBColors.transparent else SBBColors.white)
            contentColor(if (isDarkMode) SBBColors.smoke else SBBColors.graphite)
            borderColor(if (isDarkMode) SBBColors.iron else SBBColors.cloud)
        }
    }

    loading {
        animate {
            background(if (isDarkMode) SBBColors.transparent else SBBColors.white)
            contentColor(if (isDarkMode) SBBColors.smoke else SBBColors.graphite)
            borderColor(if (isDarkMode) SBBColors.iron else SBBColors.cloud)
        }
    }
}


