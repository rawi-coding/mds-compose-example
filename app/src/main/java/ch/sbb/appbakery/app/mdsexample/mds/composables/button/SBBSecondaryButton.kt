package ch.sbb.appbakery.app.mdsexample.mds.composables.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.rememberUpdatedStyleState
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.SBBButtonState
import ch.sbb.appbakery.app.mdsexample.mds.composables.button.style.buttonStateKey
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBTheme

@Composable
fun SBBSecondaryButton(
    modifier: Modifier = Modifier,
    style: Style = Style,
    labelText: String? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    state: SBBButtonState = SBBButtonState.Default,
    label: (@Composable RowScope.() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isEnabled = enabled && state != SBBButtonState.Loading
    val effectiveStyle = SBBTheme.styles!!.secondaryButtonStyle then style
    val styleState = rememberUpdatedStyleState(interactionSource) {
        it.isEnabled = isEnabled
        it[buttonStateKey] = state
    }

    val labelSlot: (@Composable RowScope.() -> Unit)? = when {
        label != null -> label
        !labelText.isNullOrBlank() -> {
            {
                Text(text = labelText)
            }
        }

        else -> null
    }

    Box(
        modifier = modifier
            .styleable(styleState, effectiveStyle)
            .clickable(
                enabled = isEnabled,
                interactionSource = interactionSource,
                indication = null,
                role = Role.Button,
                onClick = onClick,
            ),
        contentAlignment = Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (state == SBBButtonState.Loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp),
                    strokeWidth = 2.dp,
                )
            } else {
                labelSlot?.invoke(this)
            }
        }
    }
}




