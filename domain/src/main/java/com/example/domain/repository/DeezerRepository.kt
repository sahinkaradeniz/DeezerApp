package com.example.domain.repository

import com.example.common.ResponseResult
import com.example.domain.entity.*

/**
 * Repository interface for accessing Deezer data.
 */
interface DeezerRepository {
    /**
     * Adds a song to favorites.
     *
     * @param favoritesEntity The FavoritesEntity to add.
     * @return ResponseResult containing the added FavoritesEntity.
     */
    suspend fun addSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    /**
     * Retrieves all favorite songs.
     *
     * @return ResponseResult containing the list of favorite songs.
     */
    suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesEntity>>

    /**
     * Deletes a song from favorites.
     *
     * @param favoritesEntity The FavoritesEntity to delete.
     * @return ResponseResult containing the deleted FavoritesEntity.
     */
    suspend fun deleteSongToFavorites(favoritesEntity: FavoritesEntity): ResponseResult<FavoritesEntity>

    /**
     * Retrieves a favorite song with the given ID.
     *
     * @param id The ID of the favorite song.
     * @return ResponseResult containing the favorite song.
     */
    suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesEntity>

    /**
     * Retrieves all genres of music.
     *
     * @return ResponseResult containing the list of music genres.
     */
    suspend fun getAllGenresOfMusic(): ResponseResult<List<MusicGenreEntity>>

    /**
     * Retrieves genre artists with the given genre ID.
     *
     * @param genreId The genre ID.
     * @return ResponseResult containing the list of genre artists.
     */
    suspend fun getGenreArtistsWithGenreId(genreId: Int): ResponseResult<List<GenreArtistsEntity>>

    /**
     * Retrieves an artist with the given artist ID.
     *
     * @param artistId The artist ID.
     * @return ResponseResult containing the artist.
     */
    suspend fun getArtistWithArtistId(artistId: Int): ResponseResult<ArtistEntity>

    /**
     * Retrieves artist albums with the given artist ID.
     *
     * @param artistId The artist ID.
     * @return ResponseResult containing the list of artist albums.
     */
    suspend fun getArtistAlbumsWithArtistId(artistId: Int): ResponseResult<List<ArtistAlbumsEntity>>

    /**
     * Retrieves album tracks with the given album ID.
     *
     * @param albumId The album ID.
     * @return ResponseResult containing the list of album tracks.
     */
    suspend fun getAlbumTracksWithAlbumId(albumId: Int): ResponseResult<List<AlbumTracksEntity>>
}
