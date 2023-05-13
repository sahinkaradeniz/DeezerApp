package com.example.domain.usecase.getAlbumTracksWithAlbumId

import com.example.common.ResponseResult
import com.example.domain.entity.AlbumTracksEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetAlbumTracksWithAlbumIdUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetAlbumTracksWithAlbumIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetAlbumTracksWithAlbumIdUseCase {

    /**
     * Retrieves the tracks of an album with the specified albumId.
     *
     * @param albumId The ID of the album.
     * @return ResponseResult containing the list of AlbumTracksEntity.
     */
    override suspend fun invoke(albumId: Int): ResponseResult<List<AlbumTracksEntity>> {
        return deezerRepository.getAlbumTracksWithAlbumId(albumId)
    }
}
