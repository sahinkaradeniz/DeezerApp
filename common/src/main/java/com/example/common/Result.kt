package com.example.common

sealed interface Result<out T> {

    data class Success<T>(val data: T?) : Result<T>

    sealed interface Error<T> : Result<T> {
        val error: ResultError

        data class IOException<T>(override val error: ResultError) : Error<T>

        data class InternetUnavailableException<T>(
            override val error: ResultError
        ) : Error<T>

        data class ApiError<T>(override val error: ResultError) : Error<T>

    }
}

inline fun <T> Result<T>.onSuccess(handler: (T?) -> Unit): Result<T> =
    this.also {
        if (this is Result.Success)
            handler(data)
    }

inline fun <T> Result<T>.onError(handler: (Result.Error<T>?) -> Unit): Result<T> =
    this.also {
        if (this is Result.Error)
            handler(this)
    }

data class ResultError(val errorMessage: String?, val errorCode: Int? = null)

