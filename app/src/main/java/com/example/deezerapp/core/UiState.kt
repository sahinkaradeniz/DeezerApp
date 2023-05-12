package com.example.deezerapp.core

/**
 * UiState is a sealed class that represents the different states of the user interface.
 * It provides a standardized way to handle loading, success, and error states.
 *
 * @param T The type of data associated with the success state.
 */
sealed class UiState<out T> {

    /**
     * Represents the loading state of the user interface.
     * No data is associated with this state.
     */
    object Loading : UiState<Nothing>()

    /**
     * Represents the success state of the user interface.
     *
     * @param data The data associated with the success state.
     */
    data class Success<T>(val data: T?) : UiState<T>()

    /**
     * Represents the error state of the user interface.
     *
     * @param message The error message associated with the error state.
     */
    data class Error(val message: String) : UiState<Nothing>()
}
