package com.alpertign.diaryapp.util

/**
 * Created by Alperen Acikgoz on 06,August,2023
 */

fun String.extractBetweenBrackets(): String? {
    val startIndex = indexOf('(')
    val endIndex = indexOf(')', startIndex)

    if (startIndex == -1 || endIndex == -1 || endIndex <= startIndex) {
        return null
    }

    return substring(startIndex + 1, endIndex)
}