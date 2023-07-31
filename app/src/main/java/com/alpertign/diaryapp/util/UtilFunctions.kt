package com.alpertign.diaryapp.util

import io.realm.kotlin.types.RealmInstant
import java.time.Instant

/**
 * Created by Alperen Acikgoz on 31,July,2023
 */

fun RealmInstant.toInstant(): Instant{
    val sec : Long = this.epochSeconds
    val nano : Int = this.nanosecondsOfSecond
    return if (sec >= 0){
        Instant.ofEpochSecond(sec, nano.toLong())
    }else{
        Instant.ofEpochSecond(sec-1, 1_000_000 + nano.toLong())
    }
}