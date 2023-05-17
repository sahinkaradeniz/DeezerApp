package com.example.deezerapp.util.manager
import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class MediaPlayerManager @Inject constructor(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying = _isPlaying.asStateFlow()

    fun startPlayback(url: String) {
        stopPlayback()

        mediaPlayer = MediaPlayer().apply {
            setDataSource(context, Uri.parse(url))
            setOnPreparedListener {
                it.start()
                _isPlaying.value = true
            }
            setOnCompletionListener {
                stopPlayback()
            }
            prepareAsync()
        }
    }

    private fun stopPlayback() {
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        _isPlaying.value = false
    }

    fun togglePlayback() {
        if (_isPlaying.value) {
            mediaPlayer?.pause()
        } else {
            mediaPlayer?.start()
        }
        _isPlaying.value = !_isPlaying.value
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
