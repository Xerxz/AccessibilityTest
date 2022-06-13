package com.xerxz.accessibilitytest.view.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.xerxz.accessibilitytest.view.component.AccessibilityBottomBar
import com.xerxz.accessibilitytest.view.component.AccessibilityScaffold
import com.xerxz.accessibilitytest.view.component.AccessibilityTopBar
import com.xerxz.accessibilitytest.view.screen.accessibility.AccessibilityScreen
import com.xerxz.accessibilitytest.view.screen.accessibility.AccessibilityViewModel
import com.xerxz.accessibilitytest.view.screen.semantics.SemanticsScreen
import com.xerxz.accessibilitytest.view.screen.semantics.SemanticsViewModel

@Composable
fun NavGraph(
    startDestination: String = NavScreen.Accessibility.route,
    _accessibilityViewModel: AccessibilityViewModel,
    _semanticsViewModel: SemanticsViewModel
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Provided via mainActivity, use Hilt to inject in viewmodel directly in future
    val accessibilityViewModel: AccessibilityViewModel = _accessibilityViewModel
    val semanticsViewModel: SemanticsViewModel = _semanticsViewModel

    AccessibilityScaffold (
        bottomBar = {
            BottomNav.values().forEach { navItem ->
                if (navItem.route == currentRoute) {
                    AccessibilityBottomBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colors.background,
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            Modifier.padding(innerPadding)
        ){
            composable(BottomNav.Accessibility.route){
                AccessibilityScreen(
                    viewModel = accessibilityViewModel
                )
            }

            composable(BottomNav.Semantics.route){
                SemanticsScreen(
                    viewModel = semanticsViewModel
                )
            }
        }
    }


}