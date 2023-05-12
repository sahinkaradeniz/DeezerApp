package com.example.common.extension

import androidx.fragment.app.Fragment
/**
 * Returns the parent fragment or activity of the current fragment.
 *
 * @return the parent fragment or activity of type T, or null if the parent is not of type T or if there is no parent.
 */
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
