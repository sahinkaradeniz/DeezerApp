package com.example.domain.usecase.getArtistAlbumsWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistAlbumsEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetArtistAlbumsWithArtistIdUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetArtistAlbumsWithArtistIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetArtistAlbumsWithArtistIdUseCase {

    /**
     * Retrieves artist albums with the specified artist ID.
     *
     * @param artistId The ID of the artist.
     * @return ResponseResult containing the list of ArtistAlbumsEntity.
     */
    override suspend fun invoke(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>> {
        return deezerRepository.getArtistAlbumsWithArtistId(artistId)
    }
}
