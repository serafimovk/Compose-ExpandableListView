package com.serafimov.composetest

import androidx.animation.FloatPropKey
import androidx.animation.transitionDefinition

val y = FloatPropKey()

val definition = transitionDefinition {
    state(ExpandableState.EXPANDED) {
        this[y] = 1f
    }
    state(ExpandableState.COLLAPSED) {
        this[y] = 0f
    }
    transition {
        y using physics {
            stiffness = 40f
        }
    }
}