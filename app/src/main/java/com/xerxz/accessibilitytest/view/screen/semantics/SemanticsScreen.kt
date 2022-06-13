package com.xerxz.accessibilitytest.view.screen.semantics

import android.hardware.TriggerEvent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xerxz.accessibilitytest.R
import com.xerxz.accessibilitytest.view.component.AccessibilityScaffold
import com.xerxz.accessibilitytest.view.component.AccessibilityText
import com.xerxz.accessibilitytest.view.component.AccessibilityTextHeading
import com.xerxz.accessibilitytest.view.component.AccessibilityTopBar

@Composable
fun SemanticsScreen(
    viewModel: SemanticsViewModel
) {
    val scaffoldState = rememberScaffoldState()
    val viewState = viewModel.uiState.collectAsState().value

    AccessibilityScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            AccessibilityTopBar(
                title = stringResource(id = R.string.semantics_screen_title)
            )
        },
        content = {
            Content(
                onTriggerEvent = {
                    viewModel.onTriggerEvent(it)
                }
            )
        },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Composable
private fun Content(
    onTriggerEvent: (SemanticsViewEvent) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom)
        ) {
            AccessibilityTextHeading(text = "Semantics")
            Card(modifier = Modifier.padding(4.dp)) {
                AccessibilityText(text = "Semantics, as the name implies, give meaning to a piece of UI. In this context, a “piece of UI” (or element) can mean anything from a single composable to a full screen.")
            }
        }
    }
}