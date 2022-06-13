package com.xerxz.accessibilitytest.view.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccessibilityText(
    modifier: Modifier = Modifier,
    text: String,
){
    Text(
        modifier = modifier.padding(4.dp),
        text = text
    )
}