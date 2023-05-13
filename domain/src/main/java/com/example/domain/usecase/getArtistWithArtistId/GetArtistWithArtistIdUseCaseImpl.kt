package com.example.domain.usecase.getArtistWithArtistId

import com.example.common.ResponseResult
import com.example.domain.entity.ArtistEntity
import com.example.domain.repository.DeezerRepository
import javax.inject.Inject

/**
 * Implementation of the GetArtistWithArtistIdUseCase.
 *
 * @param deezerRepository The DeezerRepository to interact with Deezer data.
 */
class GetArtistWithArtistIdUseCaseImpl @Inject constructor(
    private val deezerRepository: DeezerRepository
) : GetArtistWithArtistIdUseCase {

    /**
     * Retrieves artist with the specified artist ID.
     *
     * @param artistId The ID of the artist.
     * @return ResponseResult containing the ArtistEntity.
     */
    override suspend fun invoke(artistId: Int): ResponseResult<ArtistEntity> {
        return deezerRepository.getArtistWithArtistId(artistId)
    }
}
