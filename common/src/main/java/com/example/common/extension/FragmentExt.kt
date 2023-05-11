package com.example.common.extension

import androidx.fragment.app.Fragment

inline fun<reified T> Fragment.getParent() : T? {
    val parentFragment = this.parentFragment

    if (parentFragment != null && parentFragment is T) {
        return parentFragment
    } else {
        val activity = this.activity
        if (activity != null && activity is T) {
            return activity
        }
    }
    return null
}
