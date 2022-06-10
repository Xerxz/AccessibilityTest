package com.xerxz.accessibilitytest.domain.viewstate

data class AccessibilityViewState(
    val isLoading: Boolean = false,
    val data: String = ""
) : IViewState
