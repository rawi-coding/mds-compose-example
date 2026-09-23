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
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.defaultSBBItemStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.defaultSBBPrimaryButtonStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.defaultSBBSecondaryButtonStyle

internal val LocalSBBIsDarkMode = staticCompositionLocalOf { false }
internal val LocalSBBColorScheme =
    staticCompositionLocalOf { SBBColorScheme.sbb(isDarkMode = false) }

internal val LocalSBBStyles =
    staticCompositionLocalOf<SBBStyles?> { null }

object SBBTheme {
    val styles: SBBStyles?
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
    sbbPrimaryButtonStyle: Style = Style,
    sbbSecondaryButtonStyle: Style = Style,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSBBIsDarkMode provides darkTheme,
        LocalSBBColorScheme provides colorScheme,
        LocalSBBStyles provides SBBStyles(
            itemStyle = defaultSBBItemStyle(colorScheme, darkTheme) then sbbItemStyle,
            primaryButtonStyle = defaultSBBPrimaryButtonStyle(colorScheme, darkTheme) then sbbPrimaryButtonStyle,
            secondaryButtonStyle = defaultSBBSecondaryButtonStyle(colorScheme, darkTheme) then sbbSecondaryButtonStyle,
        ),
    ) {
        MaterialTheme(
            colorScheme = colorScheme.toMaterialColorScheme(isDarkTheme = darkTheme),
        ) {
            content()
        }
    }

}

