package ch.sbb.appbakery.app.mdsexample.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.style.disabled
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.example.composables.ComponentBadge
import ch.sbb.appbakery.app.mdsexample.example.composables.DemoColorScheme
import ch.sbb.appbakery.app.mdsexample.example.composables.ThemeControls
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.SBBItem
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.style.SBBItemStyle
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColors

@Composable
fun ItemExamplesScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    selectedColorScheme: DemoColorScheme,
    onDarkThemeChanged: (Boolean) -> Unit,
    onColorSchemeSelected: (DemoColorScheme) -> Unit,
) {
    val sectionStyle = SBBItemStyle {
        background(Color(0xFF9E273D))
        disabled {
            background(Color(0xFFC78E99))
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ThemeControls(
            isDarkTheme = isDarkTheme,
            selectedColorScheme = selectedColorScheme,
            onDarkThemeChanged = onDarkThemeChanged,
            onColorSchemeSelected = onColorSchemeSelected,
        )

        Text(
            text = "Examples",
            style = MaterialTheme.typography.titleMedium,
        )

        SBBItem(
            titleText = "Tappable with defaults",
            onClick = {},
        )

        SBBItem(
            titleText = "Leading slot example",
            leading = { ComponentBadge(label = "A") },
            onClick = {},
        )

        SBBItem(
            titleText = "Instance style override",
            style = SBBItemStyle {
                background(SBBColors.royal)
            },
            onClick = {},
        )

        SBBItem(
            titleText = "Instance style override in this section",
            style = sectionStyle,
            onClick = {},
        )

        SBBItem(
            titleText = "Not tappable -> disabled colors",
            style = sectionStyle,
        )

        SBBItem(
            style = sectionStyle,
            onClick = {},
            title = {
                Text(
                    text = "Fully custom title composable",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color(0xFFFFF6F8),
                )
            },
        )
    }
}