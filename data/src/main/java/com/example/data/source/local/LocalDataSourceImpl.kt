package com.example.data.source.local

import com.example.common.ResponseResult
import com.example.common.ResultError
import com.example.data.datastore.room.FavoritesDao
import com.example.data.dto.favorite.FavoritesDbModel
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
   private val favoritesDao: FavoritesDao
):LocalDataSource {
    override suspend fun addSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
       return try {
             favoritesDao.addSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel)
       }catch (e:Exception){
           ResponseResult.Error.IOException(
               ResultError(
                   errorMessage = e.localizedMessage ?: ""
               )
           )
       }
    }

    override suspend fun getAllFavoriteSongs(): ResponseResult<List<FavoritesDbModel>> {
        return try {
            val response =favoritesDao.getAllSongs()
            ResponseResult.Success(response)
        }catch (e:Exception){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun deleteSongToFavorites(favoritesDbModel: FavoritesDbModel): ResponseResult<FavoritesDbModel> {
        return try {
            favoritesDao.deleteSongToFavorites(favoritesDbModel)
            ResponseResult.Success(favoritesDbModel)
        }catch (e:Exception){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }

    override suspend fun getFavoriteSongWithId(id: Int): ResponseResult<FavoritesDbModel> {
        return try {
           val response =favoritesDao.getFavoriteSongWithId(id)
            ResponseResult.Success(response)
        }catch (e:Exception){
            ResponseResult.Error.IOException(
                ResultError(
                    errorMessage = e.localizedMessage ?: ""
                )
            )
        }
    }
}