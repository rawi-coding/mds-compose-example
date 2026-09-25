package ch.sbb.appbakery.app.mdsexample.mds.composables.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.style.rememberUpdatedStyleState
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.style.SBBItemStyle
import ch.sbb.appbakery.app.mdsexample.mds.composables.item.style.toStyle
import ch.sbb.appbakery.app.mdsexample.mds.theme.SBBTheme

@Composable
fun SBBItem(
    modifier: Modifier = Modifier,
    titleText: String? = null,
    title: (@Composable RowScope.() -> Unit)? = null,
    leadingIcon: ImageVector? = null,
    leading: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    style: SBBItemStyle = SBBItemStyle,
) {
    val effectiveStyle = SBBTheme.styles.itemStyle then style.toStyle()

    val enabled = onClick != null
    val interactionSource = remember { MutableInteractionSource() }
    val styleState = rememberUpdatedStyleState(interactionSource) {
        it.isEnabled = enabled
    }

    // TODO: how to handle slot styles?
    val leadingSlot: (@Composable () -> Unit)? = when {
        leading != null -> leading
        leadingIcon != null -> {
            {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = "Icon",
                )
            }
        }

        else -> null
    }

    val titleSlot: (@Composable RowScope.() -> Unit)? = when {
        title != null -> title
        !titleText.isNullOrBlank() -> {
            {
                Text(text = titleText)
            }
        }

        else -> null
    }

    var rootModifier = modifier
        .fillMaxWidth()
        .styleable(styleState, effectiveStyle)

    if (onClick != null) {
        rootModifier = rootModifier.clickable(
            onClick = onClick,
            indication = null,
            interactionSource = interactionSource,
        )
    }

    Row(
        modifier = rootModifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        leadingSlot?.invoke()
        titleSlot?.invoke(this)
    }
}



