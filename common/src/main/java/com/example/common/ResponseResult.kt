package com.example.common

sealed interface ResponseResult<out T> {

    data class Success<T>(val data: T?) : ResponseResult<T>

    sealed interface Error<T> : ResponseResult<T> {
        val error: ResultError

        data class IOException<T>(override val error: ResultError) : Error<T>

        data class InternetUnavailableException<T>(
            override val error: ResultError
        ) : Error<T>

        data class ApiError<T>(override val error: ResultError) : Error<T>

    }
}

inline fun <T> ResponseResult<T>.onSuccess(handler: (T?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Success)
            handler(data)
    }

inline fun <T> ResponseResult<T>.onError(handler: (ResponseResult.Error<T>?) -> Unit): ResponseResult<T> =
    this.also {
        if (this is ResponseResult.Error)
            handler(this)
    }

data class ResultError(val errorMessage: String?, val errorCode: Int? = null)

