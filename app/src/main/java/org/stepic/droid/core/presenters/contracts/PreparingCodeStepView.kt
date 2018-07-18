package org.stepic.droid.core.presenters.contracts

import org.stepik.android.model.structure.Step

interface PreparingCodeStepView {
    fun onStepPrepared(newStep : Step)

    fun onStepNotPrepared()

    fun onStepPreparing()
}
