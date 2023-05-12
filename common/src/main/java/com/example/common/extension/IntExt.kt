package com.example.common.extension

import java.util.concurrent.TimeUnit

fun Int.toDurationString(): String {
    val minutes = this / 60
    val seconds = this % 60
    return "%02d:%02d".format(minutes, seconds)
}
fun Int.formatDuration(): String {
    val minutes = TimeUnit.MILLISECONDS.toMinutes(this.toLong())
    val seconds = TimeUnit.MILLISECONDS.toSeconds(this.toLong()) % 60
    return String.format("%02d:%02d", minutes, seconds)
}