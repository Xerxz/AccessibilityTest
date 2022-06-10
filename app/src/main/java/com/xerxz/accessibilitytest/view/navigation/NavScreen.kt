package com.xerxz.accessibilitytest.view.navigation

//Sealed navscreen class to hold navigation screens, implicitly abstract
sealed class NavScreen(val route: String) {
    object Accessibility: NavScreen("accessibility")
}
