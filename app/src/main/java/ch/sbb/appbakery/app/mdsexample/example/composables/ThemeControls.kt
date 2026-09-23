package ch.sbb.appbakery.app.mdsexample.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBColorScheme

enum class DemoColorScheme(val label: String) {
    SBB("SBB"),
    OffBrand("Off-brand");

    fun resolve(darkTheme: Boolean): SBBColorScheme = when (this) {
        SBB -> SBBColorScheme.sbb(darkTheme)
        OffBrand -> SBBColorScheme.offBrand(darkTheme)
    }
}

@Composable
fun ThemeControls(
    isDarkTheme: Boolean,
    selectedColorScheme: DemoColorScheme,
    onDarkThemeChanged: (Boolean) -> Unit,
    onColorSchemeSelected: (DemoColorScheme) -> Unit,
) {
    var isDropdownExpanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = "Theme settings",
                style = MaterialTheme.typography.titleMedium,
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Dark theme",
                    style = MaterialTheme.typography.bodyLarge,
                )
                Switch(
                    checked = isDarkTheme,
                    onCheckedChange = onDarkThemeChanged,
                )
            }

            HorizontalDivider()

            Box {
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { isDropdownExpanded = true },
                ) {
                    Text(text = selectedColorScheme.label)
                }

                DropdownMenu(
                    expanded = isDropdownExpanded,
                    onDismissRequest = { isDropdownExpanded = false },
                ) {
                    DemoColorScheme.entries.forEach { colorScheme ->
                        DropdownMenuItem(
                            text = { Text(text = colorScheme.label) },
                            onClick = {
                                onColorSchemeSelected(colorScheme)
                                isDropdownExpanded = false
                            },
                        )
                    }
                }
            }
        }
    }
}
