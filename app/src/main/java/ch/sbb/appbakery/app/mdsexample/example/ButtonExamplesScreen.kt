package ch.sbb.appbakery.app.mdsexample.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.example.composables.DemoColorScheme
import ch.sbb.appbakery.app.mdsexample.example.composables.ThemeControls
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.SBBPrimaryButton
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.SBBSecondaryButton

@Composable
fun ButtonExamplesScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    selectedColorScheme: DemoColorScheme,
    onDarkThemeChanged: (Boolean) -> Unit,
    onColorSchemeSelected: (DemoColorScheme) -> Unit,
) {
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

        SBBPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            labelText = "Primary button",
            onClick = {},
        )

        SBBPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Primary with composable label")
            },
            onClick = {},
        )

        SBBPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            labelText = "Primary loading",
            onClick = {},
        )

        SBBSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            labelText = "Secondary button",
            onClick = {},
        )

        SBBSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Secondary loading")
            },
            onClick = {},
        )

        SBBSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            labelText = "Disabled secondary",
            onClick = {},
            enabled = false,
        )
    }
}