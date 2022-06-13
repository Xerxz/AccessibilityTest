package com.xerxz.accessibilitytest.domain.viewstate

data class SemanticsViewState(
    val isLoading: Boolean = false,
    val data: String = ""
) : IViewState
