package com.alpertign.diaryapp.navigation

import com.alpertign.diaryapp.util.Constants.WRITE_SCREEN_ARGUEMENT_KEY

/**
 * Created by Alperen Acikgoz on 24,July,2023
 */
sealed class Screen(val route: String) {
    object Authentication : Screen(route = "authentication_screen")
    object Home : Screen(route = "home_screen")
    object Write :
        Screen(route = "write_screen?$WRITE_SCREEN_ARGUEMENT_KEY={$WRITE_SCREEN_ARGUEMENT_KEY}") {
        fun passDiaryId(diaryId: String) =
            "write_screen?$WRITE_SCREEN_ARGUEMENT_KEY=$diaryId"
    }
}
