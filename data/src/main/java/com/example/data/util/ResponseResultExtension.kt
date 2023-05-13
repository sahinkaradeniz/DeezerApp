package com.example.data.util

import com.example.common.ResponseResult
import com.example.common.mapper.DeezerMapper

/**
 * Converts the ResponseResult to a domain-specific ResponseResult using the provided mapper.
 *
 * @param mapper The DeezerMapper to map the data from the original ResponseResult to the domain-specific data.
 * @return A domain-specific ResponseResult.
 */
internal fun <T, D> ResponseResult<T>.toDomain(mapper: DeezerMapper<T, D>): ResponseResult<D> {
    return when (this) {
        is ResponseResult.Success -> toDomain(mapper)
        is ResponseResult.Error -> toDomain()
    }
}

/**
 * Converts the ResponseResult.Error to a domain-specific ResponseResult.Error.
 *
 * @return A domain-specific ResponseResult.Error.
 */
private fun <T, D> ResponseResult.Error<T>.toDomain(): ResponseResult.Error<D> {
    return when (this) {
        is ResponseResult.Error.IOException -> ResponseResult.Error.IOException<D>(this.error)
        is ResponseResult.Error.InternetUnavailableException -> ResponseResult.Error.InternetUnavailableException<D>(this.error)
        is ResponseResult.Error.ApiError -> ResponseResult.Error.ApiError<D>(this.error)
    }
}

/**
 * Converts the ResponseResult.Success to a domain-specific ResponseResult.Success using the provided mapper.
 *
 * @param mapper The DeezerMapper to map the data from the original ResponseResult.Success to the domain-specific data.
 * @return A domain-specific ResponseResult.Success.
 */
private fun <T, D> ResponseResult.Success<T>.toDomain(mapper: DeezerMapper<T, D>): ResponseResult.Success<D> {
    return ResponseResult.Success<D>(data = mapper.map(this.data!!))
}
