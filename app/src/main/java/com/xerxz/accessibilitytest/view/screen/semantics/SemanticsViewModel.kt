package com.xerxz.accessibilitytest.view.screen.semantics

import com.xerxz.accessibilitytest.domain.viewstate.IViewEvent
import com.xerxz.accessibilitytest.domain.viewstate.SemanticsViewState
import com.xerxz.accessibilitytest.view.screen.BaseViewModel

class SemanticsViewModel : BaseViewModel<SemanticsViewState, SemanticsViewEvent>() {

    init {

    }

    override fun createInitialState(): SemanticsViewState {
        return SemanticsViewState()
    }

    override fun onTriggerEvent(event: SemanticsViewEvent) {
        TODO("Not yet implemented")
    }
}

sealed class SemanticsViewEvent : IViewEvent {
    class UpdateData(
        //val dto: SemanticsDto
    ) : SemanticsViewEvent()
}