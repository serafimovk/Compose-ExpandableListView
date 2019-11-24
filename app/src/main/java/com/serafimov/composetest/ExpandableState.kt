package com.serafimov.composetest

enum class ExpandableState {
    EXPANDED,
    COLLAPSED;

    companion object {
        fun toggleState(state: ExpandableState): ExpandableState {
            return if (state == EXPANDED) {
                COLLAPSED
            } else {
                EXPANDED
            }
        }
    }
}