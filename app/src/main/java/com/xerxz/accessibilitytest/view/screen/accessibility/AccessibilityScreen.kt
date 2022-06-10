package com.xerxz.accessibilitytest.view.screen.accessibility

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.xerxz.accessibilitytest.R
import com.xerxz.accessibilitytest.view.component.AccessibilityScaffold
import com.xerxz.accessibilitytest.view.component.AccessibilityTopBar
import kotlinx.coroutines.flow.Flow

@Composable
fun AccessibilityScreen(
    viewModel: AccessibilityViewModel
){
    val scaffoldState = rememberScaffoldState()
    val viewState = viewModel.uiState.collectAsState().value

    AccessibilityScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = {
            AccessibilityTopBar(
                title = stringResource(id = R.string.accessibility_screen_title)
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
    isLoading :Boolean = false,
    onTriggerEvent: (AccessibilityViewEvent) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
    ) {

        AccessibilityButton(
            modifier = Modifier.padding(8.dp),
            onClick = { /*TODO*/ },
            text = "Lägg till läkemedel",
        )

    }
}

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
        modifier = modifier,
        elevation = ButtonDefaults.elevation(8.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary
        )
    ) {
        Text(text = text)
    }
}