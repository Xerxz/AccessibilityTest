package com.xerxz.accessibilitytest.view.navigation

import com.xerxz.accessibilitytest.R

enum class BottomNav (
    val route: String,
    val iconId: Int,
    val screenName: String
){
    Accessibility(
        NavScreen.Accessibility.route,
        R.drawable.ic_baseline_accessibility_new_24,
        "Accessibility"
    )

}