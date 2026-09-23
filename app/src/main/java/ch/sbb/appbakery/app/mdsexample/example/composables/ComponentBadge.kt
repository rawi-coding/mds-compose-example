package ch.sbb.appbakery.app.mdsexample.example.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBTheme

@Composable
fun ComponentBadge(label: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(
                color = SBBTheme.colorScheme.primary,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.onPrimary,
        )
    }
}