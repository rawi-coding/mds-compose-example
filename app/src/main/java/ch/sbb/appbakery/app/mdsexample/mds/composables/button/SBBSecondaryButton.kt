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
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBTheme

/**
 * Implementation of the SBB Secondary Button.
 *
 * @param labelText label of button
 * @param enabled controls the enabled state of this button
 * @param isLoading show loading indicator instead of [labelText] and disables button
 * @param onClick called when this button is clicked
 *
 * For a complete definition of the component, please visit digital.sbb.ch
 */
@Composable
fun SBBSecondaryButton(
    modifier: Modifier = Modifier,
    labelText: String? = null,
    label: (@Composable RowScope.() -> Unit)? = null,
    onClick: () -> Unit,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    style: Style = Style,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isEnabled = enabled && !isLoading
    val effectiveStyle = SBBTheme.styles!!.secondaryButtonStyle then style
    val styleState = rememberUpdatedStyleState(interactionSource) {
        it.isEnabled = isEnabled
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
            if (isLoading) {
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




