package com.example.data.util

import com.example.common.ResponseResult
import com.example.common.mapper.DeezerMapper

internal fun<T, D> ResponseResult<T>.toDomain(mapper: DeezerMapper<T, D>) : ResponseResult<D> {
    return when(this) {
        is ResponseResult.Success -> toDomain(mapper)
        is ResponseResult.Error -> toDomain<T, D>()
    }
}

private fun <T, D> ResponseResult.Error<T>.toDomain() : ResponseResult.Error<D> {
    return when (this) {
        is ResponseResult.Error.IOException -> ResponseResult.Error.IOException<D>(
            this.error
        )

        is ResponseResult.Error.InternetUnavailableException ->ResponseResult.Error.InternetUnavailableException<D>(
            this.error
        )

        is ResponseResult.Error.ApiError -> ResponseResult.Error.ApiError<D>(
            this.error
        )
    }
}

private fun <T, D> ResponseResult.Success<T>.toDomain(mapper: DeezerMapper<T, D>) : ResponseResult.Success<D> {
    return ResponseResult.Success<D>(
        data = mapper.map(this.data!!)
    )
}