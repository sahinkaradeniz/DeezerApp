package com.example.data.datastore.api

import com.example.data.dto.albumTracks.AlbumTracksResponse
import com.example.data.dto.artistAlbums.ArtistAlbumsResponse
import com.example.data.dto.artist.ArtistResponse
import com.example.data.dto.genreArtists.GenreArtistsResponse
import com.example.data.dto.genre.MusicGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * DeezerApi defines API operations for the Deezer music service.
 */
interface DeezerApi {
    /**
     * Returns all genres of music.
     *
     * @return A MusicGenreResponse object representing the music genres.
     */
    @GET("genre")
    suspend fun getGenresOfMusic(): MusicGenreResponse

    /**
     * Returns artists associated with a particular genre.
     *
     * @param genre_id The ID of the genre from which the artists will be retrieved.
     * @return A GenreArtistsResponse object representing the artists of the genre.
     */
    @GET("genre/{genre_id}/artists")
    suspend fun getGenreArtistsWithGenreId(
        @Path("genre_id") genre_id: Int,
    ): GenreArtistsResponse

    /**
     * Returns an artist with the specified artist ID.
     *
     * @param artist_id The ID of the artist to be retrieved.
     * @return An ArtistResponse object representing the artist.
     */
    @GET("artist/{artist_id}")
    suspend fun getArtistWithArtistId(
        @Path("artist_id") artist_id: Int,
    ): ArtistResponse

    /**
     * Returns albums of the artist with the specified artist ID.
     *
     * @param artist_id The ID of the artist whose albums will be retrieved.
     * @return An ArtistAlbumsResponse object representing the albums of the artist.
     */
    @GET("artist/{artist_id}/albums")
    suspend fun getArtistAlbumsWithArtistId(
        @Path("artist_id") artist_id: Int,
    ): ArtistAlbumsResponse

    /**
     * Returns tracks of the album with the specified album ID.
     *
     * @param album_id The ID of the album whose tracks will be retrieved.
     * @return An AlbumTracksResponse object representing the tracks of the album.
     */
    @GET("album/{album_id}/tracks")
    suspend fun getAlbumTracksWithAlbumId(
        @Path("album_id") albumId: Int,
    ): AlbumTracksResponse

}