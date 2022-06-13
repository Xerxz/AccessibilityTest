package com.xerxz.accessibilitytest.view.screen

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xerxz.AccessibilityTestApp
import com.xerxz.accessibilitytest.view.navigation.NavGraph
import com.xerxz.accessibilitytest.view.screen.accessibility.AccessibilityViewModel
import com.xerxz.accessibilitytest.view.screen.semantics.SemanticsViewModel
import com.xerxz.accessibilitytest.view.ui.theme.AccessibilityTestTheme

class MainActivity : ComponentActivity() {

    lateinit var application: AccessibilityTestApp


    val accessibilityViewModel: AccessibilityViewModel by viewModels()
    val semanticsViewModel: SemanticsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccessibilityTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Hilt in future to inject viewmodel
                    NavGraph(_accessibilityViewModel = accessibilityViewModel, _semanticsViewModel = semanticsViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AccessibilityTestTheme {
        Greeting("Android")
    }
}