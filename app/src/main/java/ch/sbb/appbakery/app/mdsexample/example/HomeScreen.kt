package ch.sbb.appbakery.app.mdsexample.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.DemoScreen
import ch.sbb.appbakery.app.mdsexample.example.composables.ComponentBadge
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.SBBItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean,
    selectedColorScheme: DemoColorScheme,
    onDarkThemeChanged: (Boolean) -> Unit,
    onColorSchemeSelected: (DemoColorScheme) -> Unit,
    onNavigate: (DemoScreen) -> Unit,
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
            text = "Open a component page to browse examples and test the available SBB themes.",
            style = MaterialTheme.typography.bodyLarge,
        )

        SBBItem(
            onClick = { onNavigate(DemoScreen.Item) },
            leading = { ComponentBadge(label = "I") },
            title = {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(text = "Item")
                    Text(
                        text = "Tappable, disabled and styled examples",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            },
        )

        SBBItem(
            onClick = { onNavigate(DemoScreen.Buttons) },
            leading = { ComponentBadge(label = "B") },
            title = {
                Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                    Text(text = "Buttons")
                    Text(
                        text = "Primary and secondary button states",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            },
        )
    }
}