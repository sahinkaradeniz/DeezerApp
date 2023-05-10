package com.example.data.dto.albumTracks

import com.google.gson.annotations.SerializedName

data class AlbumTracksData (

        @SerializedName("id"                      ) var id                    : Int,
        @SerializedName("readable"                ) var readable              : Boolean,
        @SerializedName("title"                   ) var title                 : String,
        @SerializedName("title_short"             ) var titleShort            : String,
        @SerializedName("title_version"           ) var titleVersion          : String,
        @SerializedName("isrc"                    ) var isrc                  : String,
        @SerializedName("link"                    ) var link                  : String,
        @SerializedName("duration"                ) var duration              : Int,
        @SerializedName("track_position"          ) var trackPosition         : Int,
        @SerializedName("disk_number"             ) var diskNumber            : Int,
        @SerializedName("rank"                    ) var rank                  : Int,
        @SerializedName("explicit_lyrics"         ) var explicitLyrics        : Boolean,
        @SerializedName("explicit_content_lyrics" ) var explicitContentLyrics : Int,
        @SerializedName("explicit_content_cover"  ) var explicitContentCover  : Int,
        @SerializedName("preview"                 ) var preview               : String,
        @SerializedName("md5_image"               ) var md5Image              : String,
        @SerializedName("artist"                  ) var artist                : Artist,
        @SerializedName("type"                    ) var type                  : String

)