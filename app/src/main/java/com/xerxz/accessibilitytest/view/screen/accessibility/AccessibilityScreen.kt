package com.xerxz.accessibilitytest.view.screen.accessibility

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.focused
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xerxz.accessibilitytest.R
import com.xerxz.accessibilitytest.view.component.*
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
    isLoading: Boolean = false,
    onTriggerEvent: (AccessibilityViewEvent) -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom)
        ) {
            AccessibilityTextHeading(text = "Riktlinjer för accessibilitet")
            AccessibilityText(text = "Text < 18 pt eller Fetstil < 14 pt: Kontrast 4.5:1")
            AccessibilityText(text = "Text > 18 pt : Kontrast 3.0:1")

            AccessibilityButton(
                onClick = { /*TODO*/ },
                text = "Tryckstorlek på 48 dp",
            )

            AccessibilityCard()

            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painterResource(R.drawable.ic_baseline_accessibility_new_24),
                    contentDescription = "Accessibilitet"
                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val checkState = remember { mutableStateOf(false)}
                        AccessibilityText(text = "Checkbox")
                        Checkbox(
                            checked = checkState.value,
                            onCheckedChange = {
                                checkState.value = it
                            },
                            colors = CheckboxDefaults.colors(
                                MaterialTheme.colors.primary
                            )
                        )
                    }
                }
            }
        }

    }
}


@Composable
private fun AccessibilityCard(
    modifier: Modifier = Modifier,
){
    Card(
        Modifier
            .semantics(mergeDescendants = true) {
            }
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ){

            AccessibilityTextHeading(text = "Kort med mergeDescendants")
            AccessibilityText(text="Används för att lägga ihop Talkback element")
            AccessibilityText(text="Minskar swipeandet för användaren")
            AccessibilityText(text="Använder semantics modifier i komponenter")
            AccessibilityButton(onClick = { /*TODO*/ }, text = "Knapp 1")
            AccessibilityButton(onClick = { /*TODO*/ }, text = "Knapp 2")
            AccessibilityButton(onClick = { /*TODO*/ }, text = "Knapp 3")
        }

    }
}





@Preview
@Composable
fun MainPreview(){
    Content(onTriggerEvent = {})
}