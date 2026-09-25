@file:Suppress("unused")

package ch.sbb.appbakery.app.mdsexample.mds.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.then
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.SBBButtonStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.defaultSBBPrimaryButtonStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.defaultSBBSecondaryButtonStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.toStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.style.defaultSBBItemStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.style.toStyle

internal val LocalSBBIsDarkMode = staticCompositionLocalOf { false }
internal val LocalSBBColorScheme =
    staticCompositionLocalOf { SBBColorScheme.sbb(isDarkMode = false) }

internal val LocalSBBStyles =
    staticCompositionLocalOf<SBBStyles> { null!! }

object SBBTheme {
    val styles: SBBStyles
        @ReadOnlyComposable
        @Composable
        get() = LocalSBBStyles.current

    @Suppress("unused")
    val colorScheme: SBBColorScheme
        @ReadOnlyComposable
        @Composable
        get() = LocalSBBColorScheme.current

    @Suppress("unused")
    val isDarkMode: Boolean
        @ReadOnlyComposable
        @Composable
        get() = LocalSBBIsDarkMode.current
}

@Composable
fun SBBTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colorScheme: SBBColorScheme = SBBColorScheme.sbb(darkTheme),
    sbbItemStyle: Style = Style,
    sbbPrimaryButtonStyle: SBBButtonStyle = SBBButtonStyle,
    sbbSecondaryButtonStyle: SBBButtonStyle = SBBButtonStyle,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSBBIsDarkMode provides darkTheme,
        LocalSBBColorScheme provides colorScheme,
        LocalSBBStyles provides SBBStyles(
            itemStyle = defaultSBBItemStyle(colorScheme, darkTheme).toStyle() then sbbItemStyle,
            primaryButtonStyle = defaultSBBPrimaryButtonStyle(
                colorScheme,
                darkTheme
            ) then sbbPrimaryButtonStyle.toStyle(),
            secondaryButtonStyle = defaultSBBSecondaryButtonStyle(
                colorScheme,
                darkTheme
            ) then sbbSecondaryButtonStyle.toStyle(),
        ),
    ) {
        MaterialTheme(
            colorScheme = colorScheme.toMaterialColorScheme(isDarkTheme = darkTheme),
        ) {
            content()
        }
    }

}

