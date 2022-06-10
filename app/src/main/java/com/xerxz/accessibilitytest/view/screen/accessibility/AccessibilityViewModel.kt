package com.xerxz.accessibilitytest.view.screen.accessibility

import androidx.lifecycle.viewModelScope
import com.xerxz.accessibilitytest.domain.viewstate.AccessibilityViewState
import com.xerxz.accessibilitytest.domain.viewstate.IViewEvent
import com.xerxz.accessibilitytest.view.screen.BaseViewModel
import kotlinx.coroutines.launch

class AccessibilityViewModel: BaseViewModel<AccessibilityViewState, AccessibilityViewEvent>() {

    init {

    }

    override fun createInitialState() = AccessibilityViewState()

    override fun onTriggerEvent(event: AccessibilityViewEvent) {
        viewModelScope.launch {
            when(event){
                // Should call a real function when specific event triggers
                is AccessibilityViewEvent.UpdateData -> {}
            }
        }
    }
}

sealed class AccessibilityViewEvent : IViewEvent {
    class UpdateData(
        //val dto: AccessibilityDto
    ) : AccessibilityViewEvent()
}