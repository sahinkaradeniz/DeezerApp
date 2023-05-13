package com.example.deezerapp.core

open class Event<out T>(private val content: UiState<T>) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): UiState<T>? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): UiState<T> = content
}