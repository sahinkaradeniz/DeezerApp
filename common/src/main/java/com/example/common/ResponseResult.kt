package com.example.common

/**
 * Sealed interface representing the result of an operation that can either be a success or an error.
 *
 * @param T The type of the data result.
 */
sealed interface ResponseResult<out T> {

    /**
     * Data class representing a successful result with optional data.
     *
     * @param data The data result.
     */
    data class Success<T>(val data: T?) : ResponseResult<T>

    /**
     * Sealed interface representing an error result with an associated error object.
     *
     * @param T The type of the data result.
     */
    sealed interface Error<T> : ResponseResult<T> {
        val error: ResultError

        /**
         * Data class representing an IOException error.
         *
         * @param error The error object.
         */
        data class IOException<T>(override val error: ResultError) : Error<T>

        /**
         * Data class representing an InternetUnavailableException error.
         *
         * @param error The error object.
         */
        data class InternetUnavailableException<T>(
            override val error: ResultError
        ) : Error<T>

        /**
         * Data class representing an API error.
         *
         * @param error The error object.
         */
        data class ApiError<T>(override val error: ResultError) : Error<T>
    }
}

/**
 * Executes the given [handler] if the result is a success.
 *
 * @param handler The handler function to be executed with the data result.
 * @return The original response result.
 */
inline fun <T> ResponseResult<T>.onSuccess(handler: (T?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Success)
            handler(data)
    }

/**
 * Executes the given [handler] if the result is an error.
 *
 * @param handler The handler function to be executed with the error result.
 * @return The original response result.
 */
inline fun <T> ResponseResult<T>.onError(handler: (ResponseResult.Error<T>?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Error)
            handler(this)
    }

/**
 * Data class representing an error object.
 *
 * @param errorMessage The error message.
 * @param errorCode The error code.
 */
data class ResultError(val errorMessage: String?, val errorCode: Int? = null)
