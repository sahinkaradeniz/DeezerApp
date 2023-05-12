package com.example.common.extension

import java.util.concurrent.TimeUnit

/**
 * Converts the integer value to a duration string in the format "MM:SS".
 *
 * @return The formatted duration string.
 */
fun Int.toDurationString(): String {
    val minutes = this / 60
    val seconds = this % 60
    return "%02d:%02d".format(minutes, seconds)
}

/**
 * Formats the integer value as a duration string in the format "MM:SS".
 * The integer value represents the duration in milliseconds.
 *
 * @return The formatted duration string.
 */
fun Int.formatDuration(): String {
    val minutes = TimeUnit.MILLISECONDS.toMinutes(this.toLong())
    val seconds = TimeUnit.MILLISECONDS.toSeconds(this.toLong()) % 60
    return String.format("%02d:%02d", minutes, seconds)
}