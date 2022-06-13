package com.xerxz.accessibilitytest.view.component

import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp

@Composable
fun AccessibilityButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    enabled: Boolean = true,
){
    OutlinedButton(
        onClick = { onClick() },
        shape = CircleShape,
        modifier = modifier
            .padding(4.dp)
            .sizeIn(minWidth = 48.dp, minHeight = 48.dp),
        elevation = ButtonDefaults.elevation(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        ),
    ) {
        Text(text = text)
    }
}