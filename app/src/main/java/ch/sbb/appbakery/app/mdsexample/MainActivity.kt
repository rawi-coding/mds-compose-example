package ch.sbb.appbakery.app.mdsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import ch.sbb.appbakery.app.mdsexample.example.ButtonExamplesScreen
import ch.sbb.appbakery.app.mdsexample.example.composables.DemoColorScheme
import ch.sbb.appbakery.app.mdsexample.example.HomeScreen
import ch.sbb.appbakery.app.mdsexample.example.ItemExamplesScreen
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MdsExampleApp()
        }
    }
}

enum class DemoScreen(val title: String) {
    Home("MDS component examples"),
    Item("Item examples"),
    Buttons("Button examples"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MdsExampleApp() {
    var currentScreen by rememberSaveable { mutableStateOf(DemoScreen.Home) }
    var isDarkTheme by rememberSaveable { mutableStateOf(false) }
    var selectedColorScheme by rememberSaveable { mutableStateOf(DemoColorScheme.SBB) }

    SBBTheme(
        darkTheme = isDarkTheme,
        colorScheme = selectedColorScheme.resolve(isDarkTheme),
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = currentScreen.title)
                    },
                    navigationIcon = {
                        if (currentScreen != DemoScreen.Home) {
                            TextButton(onClick = { currentScreen = DemoScreen.Home }) {
                                Text(text = "Back")
                            }
                        }
                    },
                )
            },
        ) { innerPadding ->
            when (currentScreen) {
                DemoScreen.Home -> HomeScreen(
                    modifier = Modifier.padding(innerPadding),
                    isDarkTheme = isDarkTheme,
                    selectedColorScheme = selectedColorScheme,
                    onDarkThemeChanged = { isDarkTheme = it },
                    onColorSchemeSelected = { selectedColorScheme = it },
                    onNavigate = { currentScreen = it },
                )

                DemoScreen.Item -> ItemExamplesScreen(
                    modifier = Modifier.padding(innerPadding),
                    isDarkTheme = isDarkTheme,
                    selectedColorScheme = selectedColorScheme,
                    onDarkThemeChanged = { isDarkTheme = it },
                    onColorSchemeSelected = { selectedColorScheme = it },
                )

                DemoScreen.Buttons -> ButtonExamplesScreen(
                    modifier = Modifier.padding(innerPadding),
                    isDarkTheme = isDarkTheme,
                    selectedColorScheme = selectedColorScheme,
                    onDarkThemeChanged = { isDarkTheme = it },
                    onColorSchemeSelected = { selectedColorScheme = it },
                )
            }
        }
    }
}








